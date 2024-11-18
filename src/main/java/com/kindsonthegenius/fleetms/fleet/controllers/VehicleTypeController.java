package com.kindsonthegenius.fleetms.fleet.controllers;

import com.kindsonthegenius.fleetms.fleet.models.VehicleType;
import com.kindsonthegenius.fleetms.fleet.services.VehicleTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/fleet/vehicleTypes")
public class VehicleTypeController {

    private final VehicleTypeService vehicleTypeService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("vehicleTypes", vehicleTypeService.getAll());
        return "fleet/vehicleTypes";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public VehicleType getById(@PathVariable("id") Integer id) {
        return vehicleTypeService.getById(id);
    }

    @PostMapping
    public String addNew(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/fleet/vehicleTypes";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        vehicleTypeService.delete(id);
        return "redirect:/fleet/vehicleTypes";
    }
}
