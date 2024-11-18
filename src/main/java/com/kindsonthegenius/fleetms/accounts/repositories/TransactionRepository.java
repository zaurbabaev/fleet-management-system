package com.kindsonthegenius.fleetms.accounts.repositories;

import com.kindsonthegenius.fleetms.accounts.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
