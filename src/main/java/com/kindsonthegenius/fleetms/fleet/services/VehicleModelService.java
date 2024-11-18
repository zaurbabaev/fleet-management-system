package com.kindsonthegenius.fleetms.fleet.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.fleet.models.VehicleModel;
import com.kindsonthegenius.fleetms.fleet.repositories.VehicleModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleModelService {

    private final VehicleModelRepository vehicleModelRepository;

    public List<VehicleModel> getAll() {
        return vehicleModelRepository.findAll();
    }

    public VehicleModel getById(Integer id) {
        return vehicleModelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VehicleModel", "id", id));
    }

    public void save(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    public void delete(Integer id) {
        vehicleModelRepository.deleteById(id);
    }
}
