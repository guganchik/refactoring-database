package com.example.coursework.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComponentsIdDto {
    @Min(0)
    @NotNull(message = "Computer case ID cannot be null")
    private Long computercasesid;

    @Min(0)
    @NotNull(message = "Data storage ID cannot be null")
    private Long datastorageid;

    @Min(0)
    @NotNull(message = "Graphics card ID cannot be null")
    private Long graphicscardsid;

    @Min(0)
    @NotNull(message = "Motherboard ID cannot be null")
    private Long motherboardsid;

    @Min(0)
    @NotNull(message = "Power supply ID cannot be null")
    private Long powersupplyid;

    @Min(0)
    @NotNull(message = "Processor ID cannot be null")
    private Long processorsid;

    @Min(0)
    @NotNull(message = "RAM ID cannot be null")
    private Long ram_memoryid;
}
