package com.example.coursework.database;

import com.example.coursework.components.*;

public record PCAssembly(ComputerCases computerCases, DataStorage dataStorage, GraphicsCards graphicsCards,
                         MotherBoards motherBoards, PowerSupply powerSupply, Processors processors, RamMemory ramMemory) {
}
