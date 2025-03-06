package com.example.coursework.controllers;

import com.example.coursework.components.ComputerCases;
import com.example.coursework.dto.ComputerCasesFilterDto;
import com.example.coursework.service.ComputerCasesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/computer-cases")
@RequiredArgsConstructor
public class ComputerCaseController {
    final private ComputerCasesService computerCasesService;

    @GetMapping
    public ResponseEntity<List<ComputerCases>> getComputerCases() {
        log.info("Received request to get all computer cases");

        List<ComputerCases> list = computerCasesService.getAll();
        if (list.isEmpty()) {
            log.warn("No computer cases found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        log.info("Successfully retrieved computer cases");
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<List<ComputerCases>> setFilterComputerCases(@Valid @RequestBody ComputerCasesFilterDto computerCasesFilterDto) {
        log.info("Received request to filter computer cases with criteria: {}", computerCasesFilterDto);

        List<ComputerCases> list = computerCasesService.setFilter(computerCasesFilterDto);
        if (list.isEmpty()) {
            log.warn("No computer cases found for the provided filter criteria: {}", computerCasesFilterDto);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        log.info("Successfully retrieved filtered computer cases");
        return ResponseEntity.ok(list);
    }
}
