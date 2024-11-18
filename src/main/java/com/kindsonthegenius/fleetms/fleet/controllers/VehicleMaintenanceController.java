package com.kindsonthegenius.fleetms.fleet.controllers;

import com.kindsonthegenius.fleetms.fleet.models.VehicleMaintenance;
import com.kindsonthegenius.fleetms.fleet.services.VehicleMaintenanceService;
import com.kindsonthegenius.fleetms.fleet.services.VehicleService;
import com.kindsonthegenius.fleetms.parameters.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/fleet/maintenances")
public class VehicleMaintenanceController {

    private final VehicleMaintenanceService vehicleMaintenanceService;
    private final VehicleService vehicleService;
    private final SupplierService supplierService;

    public void addModelAttribute(Model model) {
        model.addAttribute("vehicles", vehicleService.getAll());
        model.addAttribute("suppliers", supplierService.getAll());
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("maintenance", vehicleMaintenanceService.getAll());
        return "fleet/maintenances";
    }

    @GetMapping("/add")
    public String openMaintenanceAdd(Model model) {
        addModelAttribute(model);
        return "fleet/maintenanceAdd";
    }

    @PostMapping
    public String addNew(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/fleet/maintenances";
    }

    @GetMapping("/{operation}/{id}")
    public String editOrDetails(@PathVariable("operation") String operation,
                                @PathVariable("id") Integer id,
                                Model model) {
        VehicleMaintenance vehicleMaintenance = vehicleMaintenanceService.getById(id);
        model.addAttribute("vehicleMaintenance", vehicleMaintenance);
        addModelAttribute(model);
        return String.format("fleet/maintenance%s", operation);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        vehicleMaintenanceService.delete(id);
        return "redirect:/fleet/maintenances";
    }


}
