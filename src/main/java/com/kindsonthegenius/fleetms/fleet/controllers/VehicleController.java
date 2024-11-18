package com.kindsonthegenius.fleetms.fleet.controllers;

import com.kindsonthegenius.fleetms.fleet.models.Vehicle;
import com.kindsonthegenius.fleetms.fleet.services.*;
import com.kindsonthegenius.fleetms.hr.services.EmployeeService;
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
@RequestMapping("/fleet/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private final VehicleTypeService vehicleTypeService;
    private final VehicleMakeService vehicleMakeService;
    private final VehicleModelService vehicleModelService;
    private final VehicleStatusService vehicleStatusService;
    private final EmployeeService employeeService;
    private final LocationService locationService;


    public void addModelAttributes(Model model) {
//        model.addAttribute("vehicles", vehicleService.getAll());
        model.addAttribute("vehicleTypes", vehicleTypeService.getAll());
        model.addAttribute("vehicleMakes", vehicleMakeService.getAll());
        model.addAttribute("vehicleModels", vehicleModelService.getAll());
        model.addAttribute("vehicleStatuses", vehicleStatusService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("locations", locationService.getAll());
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("vehicles", vehicleService.getAll());
        addModelAttributes(model);
        return "fleet/vehicles";
    }

    @GetMapping("/add")
    public String openVehicleAdd(Model model) {
        addModelAttributes(model);
        return "fleet/vehicleAdd";
    }

    @PostMapping
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/fleet/vehicles";
    }

    @GetMapping("/{operation}/{id}")
    public String editOrDetailsVehicle(@PathVariable("operation") String operation,
                                       @PathVariable("id") Integer id,
                                       Model model) {
        Vehicle vehicle = vehicleService.getById(id);
        model.addAttribute("vehicle", vehicle);
        addModelAttributes(model);
        return String.format("/fleet/vehicle%s", operation);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        vehicleService.delete(id);
        return "redirect:/fleet/vehicles";
    }

}
