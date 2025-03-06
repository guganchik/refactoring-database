package com.example.coursework.controllers;

import com.example.coursework.components.Processors;
import com.example.coursework.dto.ManufacturerRequestDto;
import com.example.coursework.service.ProcessorsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/processors")
@RestController
@RequiredArgsConstructor
public class ProcessorController {
    final private ProcessorsService processorsService;

    @GetMapping
    public ResponseEntity<List<Processors>> getProcessors() {
        log.info("Received request to get all processors");

        List<Processors> list = processorsService.getAll();
        if (list.isEmpty()) {
            log.warn("No processors found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        log.info("Successfully retrieved processors");
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<List<Processors>> getProcessorsByManufacturer(@Valid @RequestBody ManufacturerRequestDto manufacturer) {
        log.info("Received request to get processors by manufacturer: {}", manufacturer.getManufacturer());

        List<Processors> list = processorsService.getByManufacturer(manufacturer.getManufacturer());
        if (list.isEmpty()) {
            log.warn("No processors found for manufacturer: {}", manufacturer.getManufacturer());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        log.info("Successfully retrieved processors for manufacturer {}", manufacturer.getManufacturer());
        return ResponseEntity.ok(list);
    }
}
