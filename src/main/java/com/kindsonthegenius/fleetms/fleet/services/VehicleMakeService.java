package com.kindsonthegenius.fleetms.fleet.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.fleet.models.VehicleMake;
import com.kindsonthegenius.fleetms.fleet.repositories.VehicleMakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleMakeService {

    private final VehicleMakeRepository vehicleMakeRepository;

    public List<VehicleMake> getAll() {
        return vehicleMakeRepository.findAll();
    }

    public VehicleMake getById(Integer id) {
        return vehicleMakeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VehicleMake", "id", id));
    }

    public void save(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }

    public void delete(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }

}
