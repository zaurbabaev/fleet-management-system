package com.kindsonthegenius.fleetms.accounts.controllers;

import com.kindsonthegenius.fleetms.accounts.models.TransactionStatus;
import com.kindsonthegenius.fleetms.accounts.services.TransactionStatusService;
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
@RequestMapping("/accounts/transactionStatuses")
public class TransactionStatusController {

    private final TransactionStatusService statusService;

    @GetMapping
    public String getAll(Model model) {
        List<TransactionStatus> transactionStatuses = statusService.getAll();
        model.addAttribute("transactionStatuses", transactionStatuses);
        return "/accounts/transactionStatuses";
    }

    @GetMapping("/{id}")
    public TransactionStatus getById(@PathVariable("id") Integer id) {
        return statusService.getById(id);
    }

    @PostMapping
    public String save(TransactionStatus transactionStatus) {
        statusService.save(transactionStatus);
        return "redirect:/accounts/transactionStatuses";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        statusService.delete(id);
        return "redirect:/accounts/transactionStatuses";
    }

}
