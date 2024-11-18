package com.kindsonthegenius.fleetms.hr.controllers;

import com.kindsonthegenius.fleetms.hr.models.EmployeeStatus;
import com.kindsonthegenius.fleetms.hr.services.EmployeeService;
import com.kindsonthegenius.fleetms.hr.services.EmployeeStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hr/employeeStatuses")
@RequiredArgsConstructor
public class EmployeeStatusController {

    private final EmployeeStatusService employeeStatusService;
    private final EmployeeService employeeService;

    @GetMapping
    public String getAll(Model model) {
        List<EmployeeStatus> employeeStatuses = employeeStatusService.getAll();
        model.addAttribute("employeeStatuses", employeeStatuses);
        return "hr/employeeStatuses";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public EmployeeStatus getById(@PathVariable("id") Integer id) {
        return employeeStatusService.getById(id);
    }

    @PostMapping
    public String save(EmployeeStatus employeeStatus) {
        employeeStatusService.save(employeeStatus);
        return "redirect:/hr/employees";
    }

    @GetMapping("/delete{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeStatusService.delete(id);
        return "redirect:/hr/employees";
    }


}
