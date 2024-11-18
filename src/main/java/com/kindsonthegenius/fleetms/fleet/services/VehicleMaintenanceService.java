package com.kindsonthegenius.fleetms.fleet.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.fleet.models.VehicleMaintenance;
import com.kindsonthegenius.fleetms.fleet.repositories.VehicleHireRepository;
import com.kindsonthegenius.fleetms.fleet.repositories.VehicleMaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleMaintenanceService {

    private final VehicleMaintenanceRepository vehicleMaintenanceRepository;
    private final VehicleHireRepository vehicleHireRepository;

    public List<VehicleMaintenance> getAll() {
        return vehicleMaintenanceRepository.findAll();
    }

    public VehicleMaintenance getById(Integer id) {
        return vehicleMaintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VehicleMaintenance", "id", id));
    }

    public void save(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    public void delete(Integer id) {
        vehicleMaintenanceRepository.deleteById(id);
    }
}
