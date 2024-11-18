package com.kindsonthegenius.fleetms.accounts.controllers;

import com.kindsonthegenius.fleetms.accounts.models.TransactionType;
import com.kindsonthegenius.fleetms.accounts.services.TransactionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/accounts/transactionTypes")
public class TransactionTypeController {

    private final TransactionTypeService typeService;

    @GetMapping
    public String getAll(Model model) {
        List<TransactionType> transactionTypes = typeService.getAll();
        model.addAttribute("transactionTypes", transactionTypes);
        return "accounts/transactionTypes";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public TransactionType getById(@PathVariable("id") Integer id) {
        return typeService.getById(id);
    }

    @PostMapping
    public String save(TransactionType transactionType) {
        typeService.save(transactionType);
        return "redirect:accounts/transactionTypes";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        typeService.delete(id);
        return "redirect:accounts/transactionTypes";
    }
}
