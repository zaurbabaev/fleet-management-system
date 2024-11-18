package com.kindsonthegenius.fleetms.hr.controllers;

import com.kindsonthegenius.fleetms.hr.models.Employee;
import com.kindsonthegenius.fleetms.hr.services.EmployeeService;
import com.kindsonthegenius.fleetms.hr.services.EmployeeTypeService;
import com.kindsonthegenius.fleetms.hr.services.JobTitleService;
import com.kindsonthegenius.fleetms.parameters.services.CountryService;
import com.kindsonthegenius.fleetms.parameters.services.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hr/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final StateService stateService;
    private final JobTitleService jobTitleService;
    private final EmployeeTypeService employeeTypeService;
    private final CountryService countryService;

    public void addModelAttribute(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("jobTitles", jobTitleService.getAllJobs());
        model.addAttribute("employeeTypes", employeeTypeService.getAllEmployeeTypes());
        model.addAttribute("countries", countryService.getAll());
    }

    @GetMapping
    public String getAll(Model model) {
        addModelAttribute(model);
        return "hr/employees";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        addModelAttribute(model);
        return "hr/employeeAdd";
    }

    @GetMapping("/{operation}/{id}")
    public String editEmployee(@PathVariable("operation") String operation,
                               @PathVariable("id") Integer id,
                               Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        addModelAttribute(model);
        return String.format("hr/employee%s", operation);
    }

    @PostMapping
    public String saveNewEmployee(Employee employee) {
        employeeService.save(employee);
        return "redirect:/hr/employees";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return "redirect:/hr/employees";
    }


    @PostMapping(value = "/uploadPhoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
        Path uploadDirectory = Path.of("C:", "Dersler", "Java Dersler", "fleet_management_system_v2", "uploads");
        try {
            if (!Files.exists(uploadDirectory)) {
                Files.createDirectories(uploadDirectory);
            }

            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null || originalFilename.isEmpty()) {
                return ResponseEntity.badRequest().body("File name is invalid");
            }

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String newFilename = timestamp + "_" + originalFilename;
            Path filePath = uploadDirectory.resolve(newFilename);

            Files.write(filePath, file.getBytes());

            return ResponseEntity.ok("File uploaded successfully");

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed due to an I/O error");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    @PostMapping("/uploadPhoto2")
    public String uploadFile2(@RequestParam("file") MultipartFile file, Principal principal)
            throws IllegalStateException, IOException {
//        Path direction = Path.of(
//                "C:", "Dersler", "Java Dersler", "fleet_management_system_v2",
//                "fleetms", "src", "main", "resources", "static", "img", "photos");
        String baseDirectory = "C:\\Dersler\\Java Dersler\\fleet_management_system_v2\\fleetms\\src\\main\\resources\\static\\img\\photos";
        file.transferTo(new File(baseDirectory + principal.getName() + ".jpg"));
        return "redirect:/hr/employees";
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        String username = principal.getName();
        addModelAttribute(model);
        model.addAttribute("employee", employeeService.getByUsername(username));
        return "hr/profile";
    }
}
