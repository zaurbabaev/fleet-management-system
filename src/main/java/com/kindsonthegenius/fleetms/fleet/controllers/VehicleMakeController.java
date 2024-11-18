package com.kindsonthegenius.fleetms.fleet.controllers;

import com.kindsonthegenius.fleetms.fleet.models.VehicleMake;
import com.kindsonthegenius.fleetms.fleet.services.VehicleMakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Service
@RequiredArgsConstructor
@RequestMapping("/fleet/vehicleMakes")
public class VehicleMakeController {

    private final VehicleMakeService vehicleMakeService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("vehicleMakes", vehicleMakeService.getAll());
        return "fleet/vehicleMakes";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public VehicleMake getById(@PathVariable("id") Integer id) {
        return vehicleMakeService.getById(id);
    }

    @PostMapping
    public String addNew(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/fleet/vehicleMakes";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        vehicleMakeService.delete(id);
        return "redirect:/fleet/vehicleMakes";
    }
}
