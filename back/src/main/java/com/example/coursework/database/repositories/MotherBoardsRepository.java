package com.example.coursework.database.repositories;

import com.example.coursework.components.MotherBoards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotherBoardsRepository extends JpaRepository<MotherBoards, Long> {

}
