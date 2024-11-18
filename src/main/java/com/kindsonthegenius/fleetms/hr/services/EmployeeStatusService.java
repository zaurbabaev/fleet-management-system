package com.kindsonthegenius.fleetms.hr.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.hr.models.EmployeeStatus;
import com.kindsonthegenius.fleetms.hr.repositories.EmployeeStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeStatusService {

    private final EmployeeStatusRepository repository;

    public List<EmployeeStatus> getAll() {
        return repository.findAll();
    }

    public EmployeeStatus getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee status", "id", id));
    }

    public void save(EmployeeStatus employeeStatus) {
        repository.save(employeeStatus);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
