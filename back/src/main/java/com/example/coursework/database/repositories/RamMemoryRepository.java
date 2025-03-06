package com.example.coursework.database.repositories;

import com.example.coursework.components.RamMemory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamMemoryRepository extends JpaRepository<RamMemory, Long> {

}
