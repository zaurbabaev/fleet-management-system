package com.kindsonthegenius.fleetms.accounts.services;

import com.kindsonthegenius.fleetms.accounts.models.Transaction;
import com.kindsonthegenius.fleetms.accounts.repositories.TransactionRepository;
import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;

    public List<Transaction> getAll() {
        return repository.findAll();
    }

    public Transaction getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trancation", "id", id));
    }

    public void save(Transaction transaction) {
        repository.save(transaction);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
