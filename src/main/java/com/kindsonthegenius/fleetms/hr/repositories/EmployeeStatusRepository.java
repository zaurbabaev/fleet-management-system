package com.kindsonthegenius.fleetms.hr.repositories;

import com.kindsonthegenius.fleetms.hr.models.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeStatusRepository extends JpaRepository<EmployeeStatus, Integer> {

}
