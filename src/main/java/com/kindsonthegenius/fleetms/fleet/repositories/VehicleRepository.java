package com.kindsonthegenius.fleetms.fleet.repositories;

import com.kindsonthegenius.fleetms.fleet.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
