package com.example.coursework.service;

import com.example.coursework.components.Processors;
import com.example.coursework.database.repositories.ProcessorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessorsService {
    private final ProcessorsRepository processorsRepository;

    public List<Processors> getAll(){
        return processorsRepository.getAll();
    }

    public List<Processors> getByManufacturer(String manufacturer){
        return  processorsRepository.getByManufacturer(manufacturer);
    }

    public Processors getById(int id){
        return  processorsRepository.getById(id);
    }
}
