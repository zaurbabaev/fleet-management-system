package com.kindsonthegenius.fleetms.fleet.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.fleet.models.VehicleHire;
import com.kindsonthegenius.fleetms.fleet.repositories.VehicleHireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleHireService {

    private final VehicleHireRepository vehicleHireRepository;

    public List<VehicleHire> getAll() {
        return vehicleHireRepository.findAll();
    }

    public VehicleHire getById(Integer id) {
        return vehicleHireRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VehicleHire", "id", id));
    }

    public void save(VehicleHire vehicleHire) {
        vehicleHireRepository.save(vehicleHire);
    }

    public void delete(Integer id) {
        vehicleHireRepository.deleteById(id);
    }

}
