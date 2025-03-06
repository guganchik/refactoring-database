package com.example.coursework.controllers;

import com.example.coursework.components.*;
import com.example.coursework.database.PCAssembly;
import com.example.coursework.dto.ComponentsIdDto;
import com.example.coursework.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/assemblies")
@RestController
@RequiredArgsConstructor
public class AssemblyController {
    final private ComputerCasesService computerCasesService;
    final private DataStorageService dataStorageService;
    final private GraphicsCardsService graphicsCardsService;
    final private MotherBoardsService motherBoardsService;
    final private PowerSupplyService powerSupplyService;
    final private ProcessorsService processorsService;
    final private RamMemoryService ramMemoryService;

    @PostMapping
    public ResponseEntity<PCAssembly> getAssembly(@Valid @RequestBody ComponentsIdDto componentsId) {
        log.info("Received request to assemble PC components: {}", componentsId);
        ComputerCases computerCases = computerCasesService.getById(componentsId.getComputercasesid()).orElseThrow();
        DataStorage dataStorage = dataStorageService.getById(componentsId.getDatastorageid()).orElseThrow();
        MotherBoards motherBoards = motherBoardsService.getById(componentsId.getMotherboardsid()).orElseThrow();
        PowerSupply powerSupply = powerSupplyService.getById(componentsId.getPowersupplyid()).orElseThrow();
        Processors processors = processorsService.getById(componentsId.getProcessorsid()).orElseThrow();
        RamMemory ramMemory = ramMemoryService.getById(componentsId.getRam_memoryid()).orElseThrow();
        GraphicsCards graphicsCards = graphicsCardsService.getById(componentsId.getGraphicscardsid()).orElseThrow();

        if(computerCases==null || dataStorage==null || motherBoards==null || powerSupply==null ||
                processors==null || ramMemory==null || graphicsCards==null) {
            log.warn("One or more components not found for IDs: {}", componentsId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        PCAssembly pcAssembly = new PCAssembly(computerCases, dataStorage, graphicsCards, motherBoards,
                powerSupply, processors, ramMemory);

        log.info("Successfully assembled PC");
        return ResponseEntity.ok(pcAssembly);
    }
}
