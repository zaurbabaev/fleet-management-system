package com.kindsonthegenius.fleetms.parameters.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.parameters.models.Client;
import com.kindsonthegenius.fleetms.parameters.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getById(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}
