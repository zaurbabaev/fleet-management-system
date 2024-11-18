package com.kindsonthegenius.fleetms.parameters.repositories;

import com.kindsonthegenius.fleetms.parameters.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
