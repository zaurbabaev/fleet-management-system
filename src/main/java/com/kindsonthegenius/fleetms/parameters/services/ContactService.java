package com.kindsonthegenius.fleetms.parameters.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.parameters.models.Contact;
import com.kindsonthegenius.fleetms.parameters.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    public Contact getById(Integer id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
    }

    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }


}
