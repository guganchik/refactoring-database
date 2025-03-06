package com.example.coursework.service;

import com.example.coursework.components.RamMemory;
import com.example.coursework.database.repositories.RamMemoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RamMemoryService {
    private final RamMemoryRepository ramMemoryRepository;

    public List<RamMemory> getAll(){
        return ramMemoryRepository.findAll();
    }

    public Optional<RamMemory> getById(Long id){
        return  ramMemoryRepository.findById(id);
    }
}
