package com.example.coursework.database.repositories;

import com.example.coursework.components.DataStorage;
import com.example.coursework.components.GraphicsCards;
import com.example.coursework.components.MotherBoards;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphicsCardsRepository extends CrudRepository<GraphicsCards, Integer> {
    @Query("SELECT * FROM GraphicsCards;")
    List<GraphicsCards> getAll();

    @Query("SELECT * FROM GraphicsCards where id=:id;")
    GraphicsCards getById(@Param("id") int id);
}
