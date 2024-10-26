package com.kindsonthegenius.fleetms.parameters.controllers.restController;

import com.kindsonthegenius.fleetms.parameters.models.Country;
import com.kindsonthegenius.fleetms.parameters.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parameters/countries")
public class CountryRestController {

    private final CountryService countryService;

    @GetMapping("/{id}")
    @ResponseBody
    public Country getCountry(@PathVariable("id") Integer id) {
        return countryService.getById(id);
    }
}
