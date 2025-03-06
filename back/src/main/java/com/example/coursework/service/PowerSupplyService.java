package com.example.coursework.service;

import com.example.coursework.components.PowerSupply;
import com.example.coursework.database.repositories.PowerSupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PowerSupplyService {
    private final PowerSupplyRepository powerSupplyRepository;

    public List<PowerSupply> getAll(){
        return powerSupplyRepository.findAll();
    }

    public Optional<PowerSupply> getById(Long id){
        return  powerSupplyRepository.findById(id);
    }
}
