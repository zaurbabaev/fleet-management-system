package com.kindsonthegenius.fleetms.accounts.services;

import com.kindsonthegenius.fleetms.accounts.models.Invoice;
import com.kindsonthegenius.fleetms.accounts.repositories.InvoiceRepository;
import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    public Invoice getById(Integer id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice", "id", id));
    }

    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void delete(Integer id) {
        invoiceRepository.deleteById(id);
    }

}
