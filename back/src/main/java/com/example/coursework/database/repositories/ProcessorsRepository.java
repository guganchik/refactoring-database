package com.example.coursework.database.repositories;

import com.example.coursework.components.PowerSupply;
import com.example.coursework.components.Processors;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessorsRepository extends CrudRepository<Processors, Integer> {
    @Query("SELECT * FROM Processors;")
    List<Processors> getAll();

    @Query("SELECT * FROM Processors where id=:id;")
    Processors getById(@Param("id") int id);

    @Query("SELECT * FROM Processors where processors.manufacturer = :manufacturer;")
    List<Processors> getByManufacturer(@Param("manufacturer") String manufacturer);
}
