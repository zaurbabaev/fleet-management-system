package com.kindsonthegenius.fleetms.fleet.repositories;

import com.kindsonthegenius.fleetms.fleet.models.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Integer> {

}
