package com.example.coursework.database.repositories;

import com.example.coursework.components.Processors;
import com.example.coursework.components.RamMemory;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RamMemoryRepository extends CrudRepository<RamMemory, Integer> {
    @Query("SELECT * FROM RAM_Memory;")
    List<RamMemory> getAll();

    @Query("SELECT * FROM RAM_Memory where id=:id;")
    RamMemory getById(@Param("id") int id);
}
