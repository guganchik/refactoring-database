package com.example.coursework.database.repositories;

import com.example.coursework.components.Processors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessorsRepository extends JpaRepository<Processors, Long> {

    @Query(value = "SELECT * FROM Processors where processors.manufacturer = :manufacturer;", nativeQuery = true)
    List<Processors> getByManufacturer(@Param("manufacturer") String manufacturer);
}
