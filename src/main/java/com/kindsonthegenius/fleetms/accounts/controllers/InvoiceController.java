package com.kindsonthegenius.fleetms.accounts.controllers;

import com.kindsonthegenius.fleetms.accounts.models.Invoice;
import com.kindsonthegenius.fleetms.accounts.services.InvoiceService;
import com.kindsonthegenius.fleetms.accounts.services.InvoiceStatusService;
import com.kindsonthegenius.fleetms.parameters.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("accounts/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceStatusService invoiceStatusService;
    private final ClientService clientService;

    @GetMapping
    public String getAll(Model model) {
        List<Invoice> invoices = invoiceService.getAll();
        model.addAttribute("invoices", invoices);
        return "accounts/invoices";
    }

    @GetMapping("/add")
    public String addInvoice() {
        return "accounts/invoiceAdd";
    }

    @GetMapping("/{operation}/{id}")
    public String editInvoice(@PathVariable("operation") String operation,
                              @PathVariable("id") Integer id,
                              Model model) {
        Invoice invoice = invoiceService.getById(id);
        model.addAttribute("invoice", invoice);
        return String.format("/accounts/invoice%s", operation);
    }

    @PostMapping
    public String save(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/acoounts/invoices";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        invoiceService.delete(id);
        return "redirect:/acoounts/invoices";
    }

}
