package com.kindsonthegenius.fleetms.reports.controllers;

import com.kindsonthegenius.fleetms.accounts.services.TransactionService;
import com.kindsonthegenius.fleetms.hr.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportsController {
    private final TransactionService transactionService;
    private final EmployeeService employeeService;

    @GetMapping("/vehicles")
    public String vehicles() {
        return "reports/vehicles";
    }

    @GetMapping("/accounts")
    public String accounts(Model model) {
        model.addAttribute("transactions", transactionService.getAll());
        model.addAttribute("employeeCount", employeeService.getCountByCountry());
        return "reports/accounts";
    }

    @GetMapping("/hires")
    public String hires() {
        return "reports/hires";
    }

    @GetMapping("/helpdesk")
    public String helpdesk() {
        return "reports/helpdesk";
    }

    @GetMapping("/maintenance")
    public String maintenance() {
        return "reports/maintenance";
    }


}
