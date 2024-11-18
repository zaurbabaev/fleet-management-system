package com.kindsonthegenius.fleetms.helpdesk.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.helpdesk.models.Ticket;
import com.kindsonthegenius.fleetms.helpdesk.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Ticket geyById(Integer id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", id));
    }

    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void delete(Integer id) {
        ticketRepository.deleteById(id);
    }

}
