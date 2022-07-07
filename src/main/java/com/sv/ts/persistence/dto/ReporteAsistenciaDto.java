package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ReporteAsistenciaDto {
    private String empleado;
    private String hentrada;
    private String hsalida;
}

