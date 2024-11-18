package com.kindsonthegenius.fleetms.fleet.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.fleet.models.Vehicle;
import com.kindsonthegenius.fleetms.fleet.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle getById(Integer id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", id));
    }

    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public void delete(Integer id) {
        vehicleRepository.deleteById(id);
    }

}
