package com.kindsonthegenius.fleetms.hr.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.hr.models.Employee;
import com.kindsonthegenius.fleetms.hr.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    }

    public void save(Employee employee) {
        repository.save(employee);
    }

    public Employee getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "username", username));
    }

    public List<Object> getCountByCountry() {
        return repository.getCountByCountry();
    }

    public List<Employee> findByKeyword(String keyword) {
        return repository.findByKeyword(keyword);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
