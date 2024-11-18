package com.kindsonthegenius.fleetms.helpdesk.controllers;

import com.kindsonthegenius.fleetms.helpdesk.models.Ticket;
import com.kindsonthegenius.fleetms.helpdesk.services.TicketService;
import com.kindsonthegenius.fleetms.helpdesk.services.TicketStatusService;
import com.kindsonthegenius.fleetms.parameters.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/helpdesk/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final TicketStatusService ticketStatusService;
    private final ClientService clientService;

    public void addModelAttribute(Model model) {
        model.addAttribute("ticketStatuses", ticketStatusService.getAll());
        model.addAttribute("clients", clientService.getAll());
    }


    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("tickets", ticketService.getAll());
        addModelAttribute(model);
        return "helpdesk/tickets";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Ticket getById(@PathVariable Integer id) {
        return ticketService.geyById(id);
    }

    @GetMapping("/add")
    public String openAddPage(Model model) {
        addModelAttribute(model);
        return "helpdesk/ticketAdd";
    }

    @PostMapping
    public String addNew(Ticket ticket) {
        ticketService.save(ticket);
        return "redirect:/helpdesk/tickets";
    }

    @GetMapping("/{operation}/{id}")
    public String editOrDetailsOperation(@PathVariable("operation") String operation,
                                         @PathVariable("id") Integer id,
                                         Model model) {
        Ticket ticket = ticketService.geyById(id);
        model.addAttribute("ticket", ticket);
        return String.format("helpdesk/ticket%s", operation);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        ticketService.delete(id);
        return "redirect:/helpdesk/tickets";
    }


}
