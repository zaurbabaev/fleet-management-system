package com.kindsonthegenius.fleetms.parameters.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.parameters.models.Country;
import com.kindsonthegenius.fleetms.parameters.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public void save(Country country) {
        countryRepository.save(country);
    }

    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }

    public Country getById(Integer id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country", "id", id));
    }

}
