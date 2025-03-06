package com.example.coursework.components;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "RAM_Memory")
@AllArgsConstructor
public class RamMemory{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    String name;
    @Column
    String capacity;
    @Column
    String frequency;
    @Column
    String ramtype;
    @Column
    Integer price;
}
