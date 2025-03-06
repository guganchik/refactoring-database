package com.example.coursework.database.repositories;

import com.example.coursework.components.GraphicsCards;
import com.example.coursework.components.MotherBoards;
import com.example.coursework.components.PowerSupply;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotherBoardsRepository extends CrudRepository<MotherBoards, Integer> {
    @Query("SELECT * FROM Motherboards;")
    List<MotherBoards> getAll();

    @Query("SELECT * FROM MotherBoards where id=:id;")
    MotherBoards getById(@Param("id") int id);
}
