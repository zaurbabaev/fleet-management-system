package com.kindsonthegenius.fleetms.helpdesk.controllers;

import com.kindsonthegenius.fleetms.helpdesk.models.TicketStatus;
import com.kindsonthegenius.fleetms.helpdesk.services.TicketStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/helpdesk/ticketStatuses")
public class TicketStatusController {

    private final TicketStatusService ticketStatusService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("ticketStatuses", ticketStatusService.getAll());
        return "helpdesk/ticketStatus";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public TicketStatus getById(@PathVariable("id") Integer id) {
        return ticketStatusService.getByid(id);
    }

    @PostMapping
    public String addNew(TicketStatus ticketStatus) {
        ticketStatusService.save(ticketStatus);
        return "redirect:/helpdesk/ticketStatuses";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        ticketStatusService.delete(id);
        return "redirect:/helpdesk/ticketStatuses";
    }

}
