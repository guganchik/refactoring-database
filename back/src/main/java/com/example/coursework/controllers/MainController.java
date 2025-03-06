package com.example.coursework.controllers;

import com.example.coursework.database.Result;
import com.example.coursework.dto.PriceRequestDto;
import com.example.coursework.service.ResultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/main")
@RestController
@RequiredArgsConstructor
public class MainController {
    final private ResultService resultService;

    @PostMapping
    public ResponseEntity<List<Result>> main(@Valid @RequestBody PriceRequestDto price) {
        log.info("Received request with price: {}", price.getPrice());

        List<Result> list = resultService.getResult(price.getPrice());
        if (list.isEmpty()) {
            log.warn("No results found for price: {}", price.getPrice());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        log.info("Successfully retrieved results");
        return ResponseEntity.ok(list);
    }
}
