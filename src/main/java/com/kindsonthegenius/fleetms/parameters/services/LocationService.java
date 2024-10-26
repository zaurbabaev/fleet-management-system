package com.kindsonthegenius.fleetms.parameters.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.parameters.models.Location;
import com.kindsonthegenius.fleetms.parameters.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    public Location getById(Integer id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location", "id", id));
    }

    public void save(Location location) {
        locationRepository.save(location);
    }

    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }

    public List<Location> getByDescriptionContaining(String description){
        return locationRepository.findByDescriptionContaining(description);
    }

}
