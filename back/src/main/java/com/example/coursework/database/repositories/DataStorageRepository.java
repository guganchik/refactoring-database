package com.example.coursework.database.repositories;

import com.example.coursework.components.DataStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataStorageRepository extends JpaRepository<DataStorage, Long> {

}
