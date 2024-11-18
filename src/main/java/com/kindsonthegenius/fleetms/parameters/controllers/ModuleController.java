package com.kindsonthegenius.fleetms.parameters.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ModuleController {
    @GetMapping("/parameters/modules")
    public String getModules() {
        return "parameters/module/modules";
    }
}
