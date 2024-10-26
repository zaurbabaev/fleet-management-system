package com.kindsonthegenius.fleetms.parameters.repositories;

import com.kindsonthegenius.fleetms.parameters.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location,Integer> {

    List<Location> findByDescriptionContaining(String description);
}
