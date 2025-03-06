package com.example.coursework.controllers;

import com.example.coursework.components.MotherBoards;
import com.example.coursework.service.MotherBoardsService;
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
@RequestMapping("/mother-boards")
@RestController
@RequiredArgsConstructor
public class MotherBoardController {
    final private MotherBoardsService motherBoardsService;

    @GetMapping
    public ResponseEntity<List<MotherBoards>> getMotherBoards() {
        log.info("Received request to get all mother boards");

        List<MotherBoards> list = motherBoardsService.getAll();
        if (list.isEmpty()) {
            log.warn("No mother boards found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        log.info("Successfully retrieved mother boards");
        return ResponseEntity.ok(list);
    }
}
