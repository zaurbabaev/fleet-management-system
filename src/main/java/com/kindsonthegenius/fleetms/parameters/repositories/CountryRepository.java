package com.kindsonthegenius.fleetms.parameters.repositories;

import com.kindsonthegenius.fleetms.parameters.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
