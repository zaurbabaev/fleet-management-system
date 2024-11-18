package com.kindsonthegenius.fleetms.hr.services;


import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.hr.models.EmployeeType;
import com.kindsonthegenius.fleetms.hr.repositories.EmployeeTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeTypeService {

    private final EmployeeTypeRepository repository;

    public List<EmployeeType> getAllEmployeeTypes() {
        return repository.findAll();
    }

    public EmployeeType getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EmployeeType", "id", id));
    }

    public void saveEmployeeType(EmployeeType employeeType) {
        repository.save(employeeType);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
