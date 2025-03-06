package com.example.coursework.controllers;

import com.example.coursework.components.GraphicsCards;
import com.example.coursework.service.GraphicsCardsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/graphics-cards")
@RestController
@RequiredArgsConstructor
public class GraphicsCardController {
    final private GraphicsCardsService graphicsCardsService;

    @GetMapping
    public ResponseEntity<List<GraphicsCards>> getGraphicsCards() {
        log.info("Received request to get all graphics cards");

        List<GraphicsCards> list = graphicsCardsService.getAll();
        if (list.isEmpty()) {
            log.warn("No graphics cards found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        log.info("Successfully retrieved graphics cards");
        return ResponseEntity.ok(list);
    }
}
