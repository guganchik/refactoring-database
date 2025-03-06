package com.example.coursework.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComputerCasesFilterDto {
    @NotBlank(message = "Color cannot be empty")
    private String color;

    @NotBlank(message = "Form factor cannot be empty")
    private String formfactor;

    @Pattern(regexp = "\\d+", message = "Min price must be a numeric value")
    private String minprice;

    @Pattern(regexp = "\\d+", message = "Max price must be a numeric value")
    private String maxprice;
}
