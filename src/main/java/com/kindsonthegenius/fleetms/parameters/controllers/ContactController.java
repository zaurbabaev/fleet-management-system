package com.kindsonthegenius.fleetms.parameters.controllers;

import com.kindsonthegenius.fleetms.parameters.models.Contact;
import com.kindsonthegenius.fleetms.parameters.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/parameters/contacts")
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public String getAll(Model model) {
        List<Contact> contacts = contactService.getAll();
        model.addAttribute("contacts", contacts);
        return "parameters/contact/contacts";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Contact getContact(@PathVariable("id") Integer id) {
        return contactService.getById(id);
    }

    @GetMapping("/add")
    public String addContact() {
        return "parameters/contact/contactAdd";
    }

    @PostMapping
    public String save(Contact contact) {
        contactService.save(contact);
        return "redirect:/parameters/contacts";
    }

    @GetMapping("/{operation}/{id}")
    public String editContact(@PathVariable("operation") String operation,
                              @PathVariable("id") Integer id,
                              Model model) {
        Contact contact = contactService.getById(id);
        model.addAttribute("contact", contact);
        return String.format("parameters/contact/contact%s", operation);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        contactService.delete(id);
        return "redirect:/parameters/contacts";
    }
}
