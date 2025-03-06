package com.example.coursework.components;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name = "datastorage")
public class DataStorage{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String manufacturer;
    @Column
    private String type;
    @Column
    private String capacity;
    @Column
    private Integer price;
}
