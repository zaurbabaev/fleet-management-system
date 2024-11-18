package com.kindsonthegenius.fleetms.fleet.repositories;

import com.kindsonthegenius.fleetms.fleet.models.VehicleMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Integer> {

}
