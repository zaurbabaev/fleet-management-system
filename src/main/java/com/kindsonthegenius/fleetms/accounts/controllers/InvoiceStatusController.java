package com.kindsonthegenius.fleetms.accounts.controllers;

import com.kindsonthegenius.fleetms.accounts.models.InvoiceStatus;
import com.kindsonthegenius.fleetms.accounts.services.InvoiceService;
import com.kindsonthegenius.fleetms.accounts.services.InvoiceStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/accounts/invoceStatus")
public class InvoiceStatusController {

    private final InvoiceStatusService statusService;
    private final InvoiceService invoiceService;
    private final InvoiceStatusService invoiceStatusService;

    @GetMapping
    public String getAll(Model model) {
        List<InvoiceStatus> invoiceStatuses = invoiceStatusService.getAll();
        model.addAttribute("invoiceStatuses", invoiceStatuses);
        return "/accounts/invoiceStatuses";
    }

    @RequestMapping("{id}")
    @ResponseBody
    public Optional<InvoiceStatus> getById(@PathVariable("id") Integer id) {
        return invoiceStatusService.getById(id);
    }

    @PostMapping
    public String save(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/accounts/invoiceStatuses";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        invoiceStatusService.delete(id);
        return "redirect:/accounts/invoiceStatuses";
    }


}
