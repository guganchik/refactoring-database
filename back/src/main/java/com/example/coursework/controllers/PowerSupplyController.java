package com.example.coursework.controllers;

import com.example.coursework.components.PowerSupply;
import com.example.coursework.service.PowerSupplyService;
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
@RequestMapping("/power-supplies")
@RestController
@RequiredArgsConstructor
public class PowerSupplyController {
    final private PowerSupplyService powerSupplyService;

    @GetMapping
    public ResponseEntity<List<PowerSupply>> getPowerSupply() {
        log.info("Received request to get all power supplies");

        List<PowerSupply> list = powerSupplyService.getAll();
        if (list.isEmpty()) {
            log.warn("No power supplies found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        log.info("Successfully retrieved power supplies");
        return ResponseEntity.ok(list);
    }
}
