package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReporteInasistenciaDto {
    private String empleado;
    private String finasistencia;
}
