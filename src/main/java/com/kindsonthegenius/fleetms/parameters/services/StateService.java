package com.kindsonthegenius.fleetms.parameters.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.parameters.models.State;
import com.kindsonthegenius.fleetms.parameters.repositories.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository stateRepository;

    public List<State> getAll() {
        return stateRepository.findAll();
    }

    public State getById(Integer id) {
        return stateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("State", "id", id));
    }

    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }

    public void saveEmployee(State state) {
        stateRepository.save(state);
    }
}
