package com.example.coursework.components;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "graphicscards")
public class GraphicsCards{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String manufacturer;
    @Column
    private String vram;
    @Column
    private String graphinterface;
    @Column
    private String powerconsumption;
    @Column
    private Integer price;
}
