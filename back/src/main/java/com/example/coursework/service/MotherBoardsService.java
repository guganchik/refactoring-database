package com.example.coursework.service;

import com.example.coursework.components.MotherBoards;
import com.example.coursework.database.repositories.MotherBoardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MotherBoardsService {
    private final MotherBoardsRepository motherBoardsRepository;

    public List<MotherBoards> getAll(){
        return motherBoardsRepository.findAll();
    }

    public Optional<MotherBoards> getById(Long id){
        return  motherBoardsRepository.findById(id);
    }
}
