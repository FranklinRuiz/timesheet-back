package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class SedeDto {
    private Long idSede;
    private String nombreSede;
    private String descripcion;
    private String direccion;
    private String beacon;
}
