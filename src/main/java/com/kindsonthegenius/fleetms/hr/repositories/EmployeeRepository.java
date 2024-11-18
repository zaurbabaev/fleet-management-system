package com.kindsonthegenius.fleetms.hr.repositories;

import com.kindsonthegenius.fleetms.hr.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByUsername(String username);


    @Query(value = "SELECT e FROM Employee e WHERE concat(e.firstname,e.lastname) LIKE %:keyword%")
    List<Employee> findByKeyword(@Param("keyword") String keyword);

    @Query(value = "SELECT e.city, count(*) FROM Employee e GROUP BY e.city")
    List<Object> getCountByCountry();


}
