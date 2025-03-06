package com.example.coursework.components;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "powersupply")
public class PowerSupply{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String manufacturer;
    @Column
    private String power;
    @Column
    private String modular;
    @Column
    private Integer price;
}
