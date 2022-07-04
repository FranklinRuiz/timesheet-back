package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AsistenciaDto {
    private Long idAsistencia;
    private Long idEmpleado;
    private Long idTipoTrabajo;
    private Long idSede;
    private Long idDispositivo;
    private String horaEntrada;
    private String horaSalida;
    private String coordLong;
    private String coordLat;
    private boolean flgDiaFestivo;
}




