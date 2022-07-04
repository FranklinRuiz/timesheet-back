package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IndicadoresPersonaPorAreaDto {
    private String area;
    private Long cantidad;
}

