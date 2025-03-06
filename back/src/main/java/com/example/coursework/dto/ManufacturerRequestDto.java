package com.example.coursework.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManufacturerRequestDto {
    @NotBlank(message = "Manufacturer name cannot be empty")
    private String Manufacturer;
}
