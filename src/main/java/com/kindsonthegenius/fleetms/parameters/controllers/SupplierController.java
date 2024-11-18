package com.kindsonthegenius.fleetms.parameters.controllers;

import com.kindsonthegenius.fleetms.parameters.models.Country;
import com.kindsonthegenius.fleetms.parameters.models.Supplier;
import com.kindsonthegenius.fleetms.parameters.services.CountryService;
import com.kindsonthegenius.fleetms.parameters.services.StateService;
import com.kindsonthegenius.fleetms.parameters.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/parameters/suppliers")
public class SupplierController {

    private final CountryService countryService;
    private final StateService stateService;
    private final SupplierService supplierService;

    public void addModelAttribute(Model model) {
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("suppliers", supplierService.getAll());
    }

    @GetMapping
    public String getAll(Model model) {
        addModelAttribute(model);
        return "parameters/supplier/suppliers";
    }

    @GetMapping("/add")
    public String addSupplier(Model model) {
        List<Country> countries = countryService.getAll();
        model.addAttribute("countries", countries);
        return "parameters/supplier/supplierAdd";
    }


    @GetMapping("/{operation}/{id}")
    public String editSupplier(@PathVariable("operation") String operation,
                               @PathVariable("id") Integer id,
                               Model model) {
        Supplier supplier = supplierService.getById(id);
        model.addAttribute("supplier", supplier);
        addModelAttribute(model);
        return String.format("parameters/supplier/supplier%s", operation);
    }

    @PostMapping
    public String saveSupplier(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/parameters/suppliers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        supplierService.delete(id);
        return "redirect:/parameters/suppliers";
    }
}
