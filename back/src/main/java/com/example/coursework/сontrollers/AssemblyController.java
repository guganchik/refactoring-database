package com.example.coursework.сontrollers;

import com.example.coursework.components.*;
import com.example.coursework.database.PCAssembly;
import com.example.coursework.dto.ComponentsIdDto;
import com.example.coursework.dto.PriceRequestDto;
import com.example.coursework.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")

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

    @PostMapping("/assembly")
    public PCAssembly getAssembly(@Valid @RequestBody ComponentsIdDto componentsId) {
        System.out.println(componentsId.toString());
        ComputerCases computerCases = computerCasesService.getById(componentsId.getComputercasesid());
        DataStorage dataStorage = dataStorageService.getById(componentsId.getDatastorageid());
        MotherBoards motherBoards = motherBoardsService.getById(componentsId.getMotherboardsid());
        PowerSupply powerSupply = powerSupplyService.getById(componentsId.getPowersupplyid());
        Processors processors = processorsService.getById(componentsId.getProcessorsid());
        RamMemory ramMemory = ramMemoryService.getById(componentsId.getRam_memoryid());
        GraphicsCards graphicsCards = graphicsCardsService.getById(componentsId.getGraphicscardsid());
        return new PCAssembly(computerCases, dataStorage, graphicsCards, motherBoards,
                powerSupply, processors, ramMemory);
    }
}
