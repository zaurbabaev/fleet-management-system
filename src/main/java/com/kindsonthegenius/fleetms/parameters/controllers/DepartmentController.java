package com.kindsonthegenius.fleetms.parameters.controllers;

import com.kindsonthegenius.fleetms.hr.services.EmployeeService;
import com.kindsonthegenius.fleetms.parameters.models.Department;
import com.kindsonthegenius.fleetms.parameters.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/parameters/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        return "parameters/departments";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Department getById(@PathVariable("id") Integer id) {
        return departmentService.getById(id);
    }

    @PostMapping("/addNew")
    public String addNew(Department department) {
        departmentService.save(department);
        return "redirect:/parameters/departments";
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable("id") Integer id) {
        Department department = departmentService.getById(id);
        departmentService.save(department);
        return "redirect:/parameters/departments";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        departmentService.delete(id);
        return "redirect:/parameters/departments";
    }
}
