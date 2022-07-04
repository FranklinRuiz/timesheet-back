package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IndicadoresHorasPorSedeDto {
    private String sede;
    private String htrabajadas;
    private String hextra;
    private String htardanza;

}

