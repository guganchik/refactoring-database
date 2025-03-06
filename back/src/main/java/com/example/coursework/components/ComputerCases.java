package com.example.coursework.components;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "computercases")
public class ComputerCases {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String manufacturer;
    @Column
    private String color;
    @Column
    private String formfactor;
    @Column
    private Integer price;
}
