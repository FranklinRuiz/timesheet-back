package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CargoDto {
    private Long idCargo;
    private String codigoCargo;
    private String nombreCargo;
}
