package com.kindsonthegenius.fleetms.accounts.services;


import com.kindsonthegenius.fleetms.accounts.models.TransactionType;
import com.kindsonthegenius.fleetms.accounts.repositories.TransactionTypeRepository;
import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionTypeService {

    private final TransactionTypeRepository repository;

    public List<TransactionType> getAll() {
        return repository.findAll();
    }

    public TransactionType getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction type", "id", id));
    }

    public void save(TransactionType transactionType) {
        repository.save(transactionType);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
