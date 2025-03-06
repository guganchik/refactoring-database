package com.example.coursework.сontrollers;

import com.example.coursework.components.*;
import com.example.coursework.dto.ComponentsIdDto;
import com.example.coursework.dto.ComputerCasesFilterDto;
import com.example.coursework.dto.ManufacturerRequestDto;
import com.example.coursework.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequiredArgsConstructor
public class ComponentsController {
    final private ComputerCasesService computerCasesService;
    final private DataStorageService dataStorageService;
    final private GraphicsCardsService graphicsCardsService;
    final private MotherBoardsService motherBoardsService;
    final private PowerSupplyService powerSupplyService;
    final private ProcessorsService processorsService;
    final private RamMemoryService ramMemoryService;

    @GetMapping("/computer-cases")
    public List<ComputerCases> getComputerCases() {
        List<ComputerCases> list = computerCasesService.getAll();
        return list;
    }

    @PostMapping("/computer-cases")
    public List<ComputerCases> setFilterComputerCases(@RequestBody ComputerCasesFilterDto computerCasesFilterDto) {
        List<ComputerCases> list = computerCasesService.setFilter(computerCasesFilterDto);
        return list;
    }


    @GetMapping("/data-storage")
    public List<DataStorage> getDataStorage() {
        List<DataStorage> list = dataStorageService.getAll();
        return list;
    }

    @GetMapping("/graphics-сards")
    public List<GraphicsCards> getGraphicsCards() {
        List<GraphicsCards> list = graphicsCardsService.getAll();
        return list;
    }

    @GetMapping("/mother-boards")
    public List<MotherBoards> getMotherBoards() {
        List<MotherBoards> list = motherBoardsService.getAll();
        return list;
    }

    @GetMapping("/power-supply")
    public List<PowerSupply> getPowerSupply() {
        List<PowerSupply> list = powerSupplyService.getAll();
        return list;
    }

    @GetMapping("/processors")
    public List<Processors> getProcessors() {
        List<Processors> list = processorsService.getAll();
        return list;
    }

    @PostMapping("/processors")
    public List<Processors> getProcessorsByManufacturer(@RequestBody ManufacturerRequestDto manufacturer) {
        List<Processors> list = processorsService.getByManufacturer(manufacturer.getManufacturer());
        return list;
    }

    @GetMapping("/ram-memory")
    public List<RamMemory> getRamMemory() {
        List<RamMemory> list = ramMemoryService.getAll();
        return list;
    }
}
