package com.gmail.dev.service;

import com.gmail.dev.domain.StateUSA;
import com.gmail.dev.repository.StateUSARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateUSAService {
    private final StateUSARepository stateUSARepository;

    public StateUSAService(StateUSARepository stateUSARepository) {
        this.stateUSARepository = stateUSARepository;
    }

    public List<StateUSA> findAllStateUSA() {
        return stateUSARepository.findAll();
    }
}
