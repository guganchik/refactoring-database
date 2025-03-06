package com.example.coursework.database.repositories;

import com.example.coursework.components.ComputerCases;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerCasesRepository extends JpaRepository<ComputerCases, Long> {


    @Query(value = "SELECT * FROM ComputerCases WHERE (?1 is NULL or color = ?1) AND " +
            "(?2 is NULL or formfactor = ?2) AND" +
            "(?3 is NULL or price >= ?3) AND" +
            "(?4 is NULL or price <= ?4);", nativeQuery = true)
    List<ComputerCases> filterComputerCases(String color, String formfactor, String minprice, String maxprice);
}
