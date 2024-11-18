package com.kindsonthegenius.fleetms.fleet.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.fleet.models.VehicleStatus;
import com.kindsonthegenius.fleetms.fleet.repositories.VehicleStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleStatusService {

    private final VehicleStatusRepository vehicleStatusRepository;

    public List<VehicleStatus> getAll() {
        return vehicleStatusRepository.findAll();
    }

    public VehicleStatus getById(Integer id) {
        return vehicleStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VehicleStatus", "id", id));
    }

    public void save(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    public void delete(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }


}
