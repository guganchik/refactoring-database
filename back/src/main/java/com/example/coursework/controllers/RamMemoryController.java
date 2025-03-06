package com.example.coursework.controllers;

import com.example.coursework.components.*;
import com.example.coursework.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/ram-memories")
@RestController
@RequiredArgsConstructor
public class RamMemoryController {
    final private RamMemoryService ramMemoryService;

    @GetMapping
    public ResponseEntity<List<RamMemory>> getRamMemory() {
        log.info("Received request to get all RAM memories");

        List<RamMemory> list = ramMemoryService.getAll();
        if (list.isEmpty()) {
            log.warn("No RAM memories found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        log.info("Successfully retrieved RAM memories");
        return ResponseEntity.ok(list);
    }
}
