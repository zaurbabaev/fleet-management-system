package com.kindsonthegenius.fleetms.fleet.controllers;

import com.kindsonthegenius.fleetms.fleet.models.VehicleModel;
import com.kindsonthegenius.fleetms.fleet.services.VehicleModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/fleet/vehicleModels")
public class VehicleModelController {

    private final VehicleModelService vehicleModelService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("vehicleModels", vehicleModelService.getAll());
        return "fleet/vehicleModels";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public VehicleModel getById(@PathVariable("id") Integer id) {
        return vehicleModelService.getById(id);
    }

    @PostMapping
    public String addNew(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/fleet/vehicleModels";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        vehicleModelService.delete(id);
        return "redirect:/fleet/vehicleModels";
    }

}
