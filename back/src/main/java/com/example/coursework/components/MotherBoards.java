package com.example.coursework.components;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "motherboards")
public class MotherBoards{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    String name;
    @Column
    String manufacturer;
    @Column
    String formfactor;
    @Column
    String ramslots;
    @Column
    String motherinterface;
    @Column
    String socket;
    @Column
    Integer price;
}
