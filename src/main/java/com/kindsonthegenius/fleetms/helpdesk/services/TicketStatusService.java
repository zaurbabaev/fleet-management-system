package com.kindsonthegenius.fleetms.helpdesk.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.helpdesk.models.TicketStatus;
import com.kindsonthegenius.fleetms.helpdesk.repositories.TicketStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketStatusService {

    private final TicketStatusRepository ticketStatusRepository;

    public List<TicketStatus> getAll() {
        return ticketStatusRepository.findAll();
    }

    public TicketStatus getByid(Integer id) {
        return ticketStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TicketStatus", "id", id));
    }

    public void save(TicketStatus ticketStatus) {
        ticketStatusRepository.save(ticketStatus);
    }

    public void delete(Integer id) {
        ticketStatusRepository.deleteById(id);
    }
}
