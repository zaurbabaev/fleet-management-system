package com.kindsonthegenius.fleetms.fleet.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.fleet.models.VehicleMovement;
import com.kindsonthegenius.fleetms.fleet.repositories.VehicleMovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleMovementService {

    private final VehicleMovementRepository vehicleMovementRepository;

    public List<VehicleMovement> getAll() {
        return vehicleMovementRepository.findAll();
    }

    public VehicleMovement getById(Integer id) {
        return vehicleMovementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VehicleMovement", "id", id));
    }

    public void save(VehicleMovement vehicleMovement) {
        vehicleMovementRepository.save(vehicleMovement);
    }

    public void delete(Integer id) {
        vehicleMovementRepository.deleteById(id);
    }
}
