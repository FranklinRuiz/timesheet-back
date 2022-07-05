package com.sv.ts.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class AsistenciaDto {
    private Long idAsistencia;
    private Long idEmpleado;
    private String empleado;
    private Long idTipoTrabajo;
    private String tipoTrabajo;
    private String horaEntrada;
    private String horaSalida;
    private LocalDateTime fecha;
}
