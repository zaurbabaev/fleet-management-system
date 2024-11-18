package com.kindsonthegenius.fleetms.accounts.repositories;

import com.kindsonthegenius.fleetms.accounts.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {

}
