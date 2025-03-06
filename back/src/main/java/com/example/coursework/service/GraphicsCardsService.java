package com.example.coursework.service;

import com.example.coursework.components.GraphicsCards;
import com.example.coursework.database.repositories.GraphicsCardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GraphicsCardsService {
    private final GraphicsCardsRepository graphicsCardsRepository;

    public List<GraphicsCards> getAll(){
        return graphicsCardsRepository.getAll();
    }

    public GraphicsCards getById(int id){
        return  graphicsCardsRepository.getById(id);
    }
}
