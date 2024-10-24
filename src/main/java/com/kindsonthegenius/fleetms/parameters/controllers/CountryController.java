package com.kindsonthegenius.fleetms.parameters.controllers;

import com.kindsonthegenius.fleetms.parameters.models.Country;
import com.kindsonthegenius.fleetms.parameters.services.CountryService;
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
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public String getAll(Model model) {
        List<Country> countries = countryService.getAll();
        model.addAttribute("countries", countries);
        return "parameters/country/countries";
    }

    @GetMapping("/add")
    public String addCountry() {
        return "parameters/country/countryAdd";
    }

    @PostMapping
    public String save(Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }

    @GetMapping("/edit/{id}")
    public String editCountry(@PathVariable("id") Integer id, Model model) {
        Country foundCountry = countryService.getById(id);
        model.addAttribute("country", foundCountry);
        return "parameters/country/countryEdit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        countryService.delete(id);
        return "redirect:/countries";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        Country foundCountry = countryService.getById(id);
        model.addAttribute("country", foundCountry);
        return "parameters/country/countryDetails";
    }




}
