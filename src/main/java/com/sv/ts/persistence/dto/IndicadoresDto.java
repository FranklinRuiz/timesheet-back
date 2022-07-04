package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IndicadoresDto {
    private Long total;
    private Long hombres;
    private Long mujeres;
}

