package com.example.coursework.service;

import com.example.coursework.components.ComputerCases;
import com.example.coursework.database.repositories.ComputerCasesRepository;
import com.example.coursework.dto.ComputerCasesFilterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComputerCasesService {
    private final ComputerCasesRepository computerCasesRepository;

    public List<ComputerCases> getAll(){
        return computerCasesRepository.findAll();
    }

    public Optional<ComputerCases> getById(Long id){
        return computerCasesRepository.findById(id);
    }

    public List<ComputerCases> setFilter(ComputerCasesFilterDto computerCasesFilterDto) {
        return computerCasesRepository.filterComputerCases(computerCasesFilterDto.getColor(),
                computerCasesFilterDto.getFormfactor(), computerCasesFilterDto.getMinprice(),
                computerCasesFilterDto.getMaxprice());
    }
}
