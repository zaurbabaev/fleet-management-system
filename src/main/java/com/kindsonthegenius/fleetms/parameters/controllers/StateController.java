package com.kindsonthegenius.fleetms.parameters.controllers;

import com.kindsonthegenius.fleetms.parameters.models.Country;
import com.kindsonthegenius.fleetms.parameters.models.State;
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
@RequestMapping("parameters/states")
public class StateController {

    private final StateService stateService;
    private final CountryService countryService;

    public void addModelAttribute(Model model) {
        List<State> states = stateService.getAll();
        List<Country> countries = countryService.getAll();
        model.addAttribute("states", states);
        model.addAttribute("countries", countries);
    }

    @GetMapping
    public String getAll(Model model) {
        List<State> states = stateService.getAll();
        model.addAttribute("states", states);
        return "parameters/state/states";
    }

    @GetMapping("/add")
    public String addState(Model model) {
        addModelAttribute(model);
        return "parameters/state/stateAdd";
    }

    @PostMapping
    public String save(State state) {
        stateService.saveEmployee(state);
        return "redirect:/parameters/states";
    }

    @GetMapping("/{operation}/{id}")
    public String editState(@PathVariable("operation") String operation,
                            @PathVariable("id") Integer id,
                            Model model) {
        addModelAttribute(model);
        State foundState = stateService.getById(id);
        model.addAttribute("state", foundState);
        return String.format("parameters/state/state%s", operation);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        stateService.delete(id);
        return "redirect:/parameters/states";
    }


}
