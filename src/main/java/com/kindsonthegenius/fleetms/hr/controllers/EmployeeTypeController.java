package com.kindsonthegenius.fleetms.hr.controllers;

import com.kindsonthegenius.fleetms.hr.models.EmployeeType;
import com.kindsonthegenius.fleetms.hr.services.EmployeeTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hr/employeeTypes")
@RequiredArgsConstructor
public class EmployeeTypeController {

    private final EmployeeTypeService employeeTypeService;

    @GetMapping
    public String getAll(Model model) {
        List<EmployeeType> employeeTypes = employeeTypeService.getAllEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypes);
        return "hr/employeeTypes";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public EmployeeType getById(@PathVariable("id") Integer id) {
        return employeeTypeService.getById(id);
    }

    @PostMapping
    public String save(EmployeeType employeeType) {
        employeeTypeService.saveEmployeeType(employeeType);
        return "redirect:/hr/employeeTypes";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeTypeService.delete(id);
        return "redirect:/hr/employeeTypes";
    }
}
