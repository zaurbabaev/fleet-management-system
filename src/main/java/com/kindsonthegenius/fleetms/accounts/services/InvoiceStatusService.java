package com.kindsonthegenius.fleetms.accounts.services;

import com.kindsonthegenius.fleetms.accounts.models.InvoiceStatus;
import com.kindsonthegenius.fleetms.accounts.repositories.InvoiceStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceStatusService {

    private final InvoiceStatusRepository repository;

    public List<InvoiceStatus> getAll() {
        return repository.findAll();
    }

    public Optional<InvoiceStatus> getById(Integer id) {
        return repository.findById(id);
    }

    public void save(InvoiceStatus invoiceStatus) {
        repository.save(invoiceStatus);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
