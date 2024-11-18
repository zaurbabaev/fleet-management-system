package com.kindsonthegenius.fleetms.fleet.controllers;

import com.kindsonthegenius.fleetms.fleet.models.VehicleMovement;
import com.kindsonthegenius.fleetms.fleet.services.VehicleMovementService;
import com.kindsonthegenius.fleetms.fleet.services.VehicleService;
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
@RequestMapping("/fleet/movements")
public class VehicleMovementController {

    private final VehicleMovementService vehicleMovementService;
    private final LocationService locationService;
    private final VehicleService vehicleService;

    public void addModelAttribute(Model model) {
        model.addAttribute("location1", locationService.getAll());
        model.addAttribute("location2", locationService.getAll());
        model.addAttribute("vehicles", vehicleService.getAll());
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("movements", vehicleMovementService.getAll());
        return "fleet/movements";
    }

    @GetMapping("/add")
    public String openMovementAddPage(Model model) {
        addModelAttribute(model);
        return "fleet/movementAdd";
    }

    @PostMapping
    public String addNew(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/fleet/movements";
    }

    @GetMapping("/{operation}/{id}")
    public String editOrDetailsOperation(@PathVariable("operation") String operation,
                                         @PathVariable("id") Integer id,
                                         Model model) {
        VehicleMovement vehicleMovement = vehicleMovementService.getById(id);
        model.addAttribute("vehicleMovement", vehicleMovement);
        return String.format("fleet/vehicle%s", operation);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        vehicleMovementService.delete(id);
        return "redirect:/fleet/movements";
    }
}
