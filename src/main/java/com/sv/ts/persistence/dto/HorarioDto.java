package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HorarioDto {
    private Long idHorario;
    private String nombre;
    private String horaInicio;
    private String horaFin;
}
