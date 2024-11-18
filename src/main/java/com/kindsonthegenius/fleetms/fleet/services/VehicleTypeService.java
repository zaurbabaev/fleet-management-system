package com.kindsonthegenius.fleetms.fleet.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.fleet.models.VehicleType;
import com.kindsonthegenius.fleetms.fleet.repositories.VehicleTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleTypeService {

    private final VehicleTypeRepository vehicleTypeRepository;

    public List<VehicleType> getAll() {
        return vehicleTypeRepository.findAll();
    }

    public VehicleType getById(Integer id) {
        return vehicleTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VehicleType", "id", id));
    }

    public void save(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    public void delete(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }
}
