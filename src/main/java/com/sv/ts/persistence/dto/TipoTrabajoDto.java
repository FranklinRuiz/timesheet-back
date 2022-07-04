package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TipoTrabajoDto {
    private Long idTipoTrabajo;
    private String nombreTipoTrabajo;
    private String abreviatura;
}
