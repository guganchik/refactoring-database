package com.example.coursework.service;

import com.example.coursework.components.DataStorage;
import com.example.coursework.database.repositories.DataStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataStorageService {
    private final DataStorageRepository dataStorageRepository;

    public List<DataStorage> getAll(){
        return dataStorageRepository.getAll();
    }

    public DataStorage getById(int id){
        return  dataStorageRepository.getById(id);
    }
}
