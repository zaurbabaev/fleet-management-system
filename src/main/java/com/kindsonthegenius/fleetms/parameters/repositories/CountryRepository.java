package com.kindsonthegenius.fleetms.parameters.repositories;

import com.kindsonthegenius.fleetms.parameters.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query(value = "SELECT c from Country c WHERE " +
            "c.description LIKE %?1% OR c.capital LIKE %?1% OR c.continent LIKE %?1% " +
            "OR c.nationality LIKE %?1% OR c.code LIKE %?1%")
    List<Country> findByKeyword(String keyword);


}
