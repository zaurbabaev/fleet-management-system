package com.kindsonthegenius.fleetms.helpdesk.repositories;

import com.kindsonthegenius.fleetms.helpdesk.models.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketStatusRepository extends JpaRepository<TicketStatus, Integer> {

}
