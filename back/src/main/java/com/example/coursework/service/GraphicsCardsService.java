package com.example.coursework.service;

import com.example.coursework.components.GraphicsCards;
import com.example.coursework.database.repositories.GraphicsCardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GraphicsCardsService {
    private final GraphicsCardsRepository graphicsCardsRepository;

    public List<GraphicsCards> getAll(){
        return graphicsCardsRepository.findAll();
    }

    public Optional<GraphicsCards> getById(Long id){
        return  graphicsCardsRepository.findById(id);
    }
}
