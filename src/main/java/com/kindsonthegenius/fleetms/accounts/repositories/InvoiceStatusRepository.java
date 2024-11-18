package com.kindsonthegenius.fleetms.accounts.repositories;

import com.kindsonthegenius.fleetms.accounts.models.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus, Integer> {

}
