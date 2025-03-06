package com.example.coursework.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComponentsIdDto {
    @Min(0)
    private Integer computercasesid;
    @Min(0)
    private Integer datastorageid;
    @Min(0)
    private Integer graphicscardsid;
    @Min(0)
    private Integer motherboardsid;
    @Min(0)
    private Integer powersupplyid;
    @Min(0)
    private Integer processorsid;
    @Min(0)
    private Integer ram_memoryid;
}
