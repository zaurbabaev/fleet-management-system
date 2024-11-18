package com.kindsonthegenius.fleetms.accounts.controllers;

import com.kindsonthegenius.fleetms.accounts.models.Transaction;
import com.kindsonthegenius.fleetms.accounts.services.TransactionService;
import com.kindsonthegenius.fleetms.accounts.services.TransactionStatusService;
import com.kindsonthegenius.fleetms.accounts.services.TransactionTypeService;
import com.kindsonthegenius.fleetms.hr.services.EmployeeService;
import com.kindsonthegenius.fleetms.parameters.services.ClientService;
import com.kindsonthegenius.fleetms.parameters.services.ContactService;
import com.kindsonthegenius.fleetms.parameters.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/accounts/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionStatusService transactionStatusService;
    private final TransactionTypeService transactionTypeService;
    private final ClientService clientService;
    private final ContactService contactService;
    private final SupplierService supplierService;
    private final EmployeeService employeeService;


    public void addModelAttribute(Model model) {
        model.addAttribute("transactionStatuses", transactionStatusService.getAll());
        model.addAttribute("transactionTypes", transactionTypeService.getAll());
        model.addAttribute("contacts", contactService.getAll());
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("suppliers", supplierService.getAll());
        model.addAttribute("employees", employeeService.getAll());
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("transactions", transactionService.getAll());
        addModelAttribute(model);
        return "accounts/transactions";
    }

    @GetMapping("/add")
    public String openTransactionAdd(Model model) {
        addModelAttribute(model);
        return "accounts/transactionAdd";
    }


    @PostMapping
    public String save(Transaction transaction) {
        transactionService.save(transaction);
        return "redirect:/accounts/transactions";
    }

    @GetMapping("/{operation}/{id}")
    public String editOrDetailsOperation(@PathVariable("operation") String operation,
                                         @PathVariable("id") Integer id,
                                         Model model) {
        Transaction transaction = transactionService.getById(id);
        model.addAttribute("transaction", transaction);
        return String.format("accounts/transaction%s", operation);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        transactionService.delete(id);
        return "redirect:/accounts/transactions";
    }

}
