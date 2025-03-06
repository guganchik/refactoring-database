package com.example.coursework.database.repositories;

import com.example.coursework.components.GraphicsCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphicsCardsRepository extends JpaRepository<GraphicsCards, Long> {

}
