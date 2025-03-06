package com.example.coursework.service;

import com.example.coursework.database.Result;
import com.example.coursework.database.repositories.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;

    public List<Result> getResult(int price){
        return resultRepository.allResult(price);
    }
}
