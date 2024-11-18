package com.kindsonthegenius.fleetms.fleet.controllers;

import com.kindsonthegenius.fleetms.fleet.models.VehicleHire;
import com.kindsonthegenius.fleetms.fleet.services.VehicleHireService;
import com.kindsonthegenius.fleetms.fleet.services.VehicleService;
import com.kindsonthegenius.fleetms.parameters.services.ClientService;
import com.kindsonthegenius.fleetms.parameters.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/fleet/hires")
public class VehicleHireController {

    private final VehicleHireService vehicleHireService;
    private final ClientService clientService;
    private final LocationService locationService;
    private final VehicleService vehicleService;


    public void addModelAttributes(Model model) {
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("locations", locationService.getAll());
        model.addAttribute("vehicle", vehicleService.getAll());
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("hires", vehicleHireService.getAll());
        return "/fleet/hires";
    }

    @GetMapping("/add")
    public String openHireAdd(Model model) {
        addModelAttributes(model);
        return "/fleet/hireAdd";
    }

    @PostMapping
    public String addNew(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/fleet/hires";
    }

    @GetMapping("/{operation}/{id}")
    public String editOrDetails(@PathVariable("operation") String operation,
                                @PathVariable("id") Integer id,
                                Model model) {
        VehicleHire hire = vehicleHireService.getById(id);
        model.addAttribute("hire", hire);
        addModelAttributes(model);
        return String.format("/fleet/hire%s", operation);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        vehicleHireService.delete(id);
        return "redirect:/fleet/hires";
    }


}
