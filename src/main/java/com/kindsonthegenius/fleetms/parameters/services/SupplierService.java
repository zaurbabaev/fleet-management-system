package com.kindsonthegenius.fleetms.parameters.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.parameters.models.Supplier;
import com.kindsonthegenius.fleetms.parameters.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public Supplier getById(Integer id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier", "id", id));
    }

    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public void delete(Integer id) {
        supplierRepository.deleteById(id);
    }
}
