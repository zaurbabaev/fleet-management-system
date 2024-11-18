package com.kindsonthegenius.fleetms.accounts.repositories;

import com.kindsonthegenius.fleetms.accounts.models.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionStatusRepository extends JpaRepository<TransactionStatus, Integer> {

}
