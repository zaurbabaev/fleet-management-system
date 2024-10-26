package com.kindsonthegenius.fleetms.parameters.controllers;

import com.kindsonthegenius.fleetms.parameters.models.Country;
import com.kindsonthegenius.fleetms.parameters.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/parameters/countries")
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
        return "redirect:/parameters/countries";
    }


    // details və editCountry metodları eyni olduğundan bu metodları birləşdirdik
    // metodun details yoxsa edit operasiyasına aid olması üçün ona operation adlı PathVariable verdik və səhifənin
    // return olunması zamanı bizim html-səhifəmizə uyğun olaraq country sözündən sonra operationda Details və ya Edit
    // müvafiq olaraq birləşdirilir. countries.html-də edit və details operasiyalarında html-səhifələrimizə uyğun
    // adlandırmaya fikir verilməlidir.th:href="@{/parameters/countries/Edit/{id} Edit və ya Details böyük hərflə
    // başlamalıdır ki, bizim country%s-ə birləşərkən html səhifəsini qaytarsın. countryEdit və ya countryDetails
    @GetMapping("/{operation}/{id}")
    public String editCountry(@PathVariable("id") Integer id,
                              @PathVariable("operation") String operation,
                              Model model) {
        Country foundCountry = countryService.getById(id);
        model.addAttribute("country", foundCountry);
        return String.format("parameters/country/country%s", operation);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        countryService.delete(id);
        return "redirect:/parameters/countries";
    }

//    @GetMapping("/details/{id}")
//    public String details(@PathVariable("id") Integer id, Model model) {
//        Country foundCountry = countryService.getById(id);
//        model.addAttribute("country", foundCountry);
//        return "parameters/country/countryDetails";
//    }


}
