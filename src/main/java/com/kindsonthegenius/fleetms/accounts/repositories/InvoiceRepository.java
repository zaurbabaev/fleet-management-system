package com.kindsonthegenius.fleetms.accounts.repositories;

import com.kindsonthegenius.fleetms.accounts.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
