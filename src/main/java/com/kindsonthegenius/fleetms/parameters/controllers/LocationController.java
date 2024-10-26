package com.kindsonthegenius.fleetms.parameters.controllers;

import com.kindsonthegenius.fleetms.parameters.models.Country;
import com.kindsonthegenius.fleetms.parameters.models.Location;
import com.kindsonthegenius.fleetms.parameters.models.State;
import com.kindsonthegenius.fleetms.parameters.services.CountryService;
import com.kindsonthegenius.fleetms.parameters.services.LocationService;
import com.kindsonthegenius.fleetms.parameters.services.StateService;
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
@RequestMapping("/parameters/locations")
public class LocationController {

    private final LocationService locationService;
    private final CountryService countryService;
    private final StateService stateService;

    public void addModelAttributes(Model model) {
        List<Location> locations = locationService.getAll();
        List<Country> countries = countryService.getAll();
        List<State> states = stateService.getAll();
        model.addAttribute("locations", locations);
        model.addAttribute("countries", countries);
        model.addAttribute("states", states);
    }

    @GetMapping
    public String getAll(Model model) {
        addModelAttributes(model);
        return "parameters/location/locations";
    }

    @GetMapping("/add")
    public String addLocation(Model model) {
        List<Country> countries = countryService.getAll();
        model.addAttribute("countries",countries);
        return "parameters/location/locationAdd";
    }

    @PostMapping
    public String saveLocation(Location location) {
        locationService.save(location);
        return "redirect:/parameters/locations";
    }

    @GetMapping("/{operation}/{id}")
    public String editLocation(@PathVariable("operation") String operation,
                               @PathVariable("id") Integer id,
                               Model model) {
        Location location = locationService.getById(id);
        model.addAttribute("location", location);
        addModelAttributes(model);
        return String.format("/parameters/locations/location%s", operation);
    }

    @GetMapping("/{id}")
    public String deleteLocation(@PathVariable("id") Integer id) {
        locationService.delete(id);
        return "redirect:/parameters/locations";
    }


}
