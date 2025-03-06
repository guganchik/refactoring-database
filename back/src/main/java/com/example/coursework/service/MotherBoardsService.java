package com.example.coursework.service;

import com.example.coursework.components.MotherBoards;
import com.example.coursework.database.repositories.MotherBoardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotherBoardsService {
    private final MotherBoardsRepository motherBoardsRepository;

    public List<MotherBoards> getAll(){
        return motherBoardsRepository.getAll();
    }

    public MotherBoards getById(int id){
        return  motherBoardsRepository.getById(id);
    }
}
