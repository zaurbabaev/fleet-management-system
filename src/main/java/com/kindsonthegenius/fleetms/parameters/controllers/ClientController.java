package com.kindsonthegenius.fleetms.parameters.controllers;

import com.kindsonthegenius.fleetms.parameters.models.Client;
import com.kindsonthegenius.fleetms.parameters.models.Country;
import com.kindsonthegenius.fleetms.parameters.models.State;
import com.kindsonthegenius.fleetms.parameters.services.ClientService;
import com.kindsonthegenius.fleetms.parameters.services.CountryService;
import com.kindsonthegenius.fleetms.parameters.services.StateService;
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
@RequestMapping("/parameters/clients")
public class ClientController {

    private final ClientService clientService;
    private final CountryService countryService;
    private final StateService stateService;


    public void addModelAttributes(Model model) {
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("states", stateService.getAll());
    }

    @GetMapping
    public String getAll(Model model) {
        addModelAttributes(model);
        return "parameters/client/clients";
    }

    @GetMapping("/add")
    public String addClient(Model model) {
        List<Country> countries = countryService.getAll();
        model.addAttribute("countries", countries);
        return "parameters/client/clientAdd";
    }

    @GetMapping("/{operation}/{id}")
    public String editClient(@PathVariable("operation") String operation,
                             @PathVariable("id") Integer id,
                             Model model) {
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        addModelAttributes(model);
        return String.format("parameters/client/client%s", operation);
    }

    @PostMapping
    public String save(Client client){
        clientService.save(client);
        return "redirect:/parameters/clients";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        clientService.delete(id);
        return "redirect:/parameters/clients";
    }


}
