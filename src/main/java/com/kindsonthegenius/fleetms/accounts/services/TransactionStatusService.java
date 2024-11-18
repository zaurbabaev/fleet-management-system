package com.kindsonthegenius.fleetms.accounts.services;

import com.kindsonthegenius.fleetms.accounts.models.TransactionStatus;
import com.kindsonthegenius.fleetms.accounts.repositories.TransactionStatusRepository;
import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionStatusService {

    private final TransactionStatusRepository repository;

    public List<TransactionStatus> getAll() {
        return repository.findAll();
    }

    public TransactionStatus getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TransactionStatus", "id", id));
    }

    public void save(TransactionStatus transactionStatus) {
        repository.save(transactionStatus);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
