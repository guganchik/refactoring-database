package com.example.coursework.service;

import com.example.coursework.components.Processors;
import com.example.coursework.database.repositories.ProcessorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProcessorsService {
    private final ProcessorsRepository processorsRepository;

    public List<Processors> getAll(){
        return processorsRepository.findAll();
    }

    public List<Processors> getByManufacturer(String manufacturer){
        return  processorsRepository.getByManufacturer(manufacturer);
    }

    public Optional<Processors> getById(Long id){
        return  processorsRepository.findById(id);
    }
}
