package com.kindsonthegenius.fleetms.fleet.controllers;

import com.kindsonthegenius.fleetms.fleet.models.VehicleStatus;
import com.kindsonthegenius.fleetms.fleet.services.VehicleStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/fleet/vehicleStatuses")
public class VehicleStatusController {

    private final VehicleStatusService vehicleStatusService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("vehicleStatuses", vehicleStatusService.getAll());
        return "fleet/vehicleStatuses";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public VehicleStatus getByid(@PathVariable("id") Integer id) {
        return vehicleStatusService.getById(id);
    }

    @PostMapping
    public String addNew(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/fleet/vehicleStatuses";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        vehicleStatusService.delete(id);
        return "redirect:/fleet/vehicleStatuses";
    }
}
