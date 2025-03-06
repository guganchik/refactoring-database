package com.example.coursework.database;

import jakarta.persistence.*;

import java.util.UUID;


public record Result(
        Integer computercasesid,
        String computercases,
        Integer datastorageid,
        String datastorage,
        Integer motherboardsid,
        String motherboards,
        Integer powersupplyid,
        String powersupply,
        Integer processorsid,
        String processors,
        Integer ram_memoryid,
        String ram_memory,
        Integer graphicscardsid,
        String graphicscards,
        Integer price) {
    //тут результаты
}