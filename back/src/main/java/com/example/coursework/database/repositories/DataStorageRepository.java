package com.example.coursework.database.repositories;

import com.example.coursework.components.ComputerCases;
import com.example.coursework.components.DataStorage;
import com.example.coursework.components.GraphicsCards;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataStorageRepository extends CrudRepository<DataStorage, Integer> {
    @Query("SELECT * FROM DataStorage;")
    List<DataStorage> getAll();

    @Query("SELECT * FROM DataStorage where id=:id;")
    DataStorage getById(@Param("id") int id);
}
