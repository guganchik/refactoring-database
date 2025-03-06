package com.example.coursework.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceRequestDto {
    @Min(0)
    private Integer price;
}
