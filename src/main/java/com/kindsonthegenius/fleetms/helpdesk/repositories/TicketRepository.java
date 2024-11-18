package com.kindsonthegenius.fleetms.helpdesk.repositories;

import com.kindsonthegenius.fleetms.helpdesk.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
