package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReporteGeneralDto {
    private String personal;
    private String area;
    private String cargo;
    private String sede;
    private String hentrada;
    private String hsalida;
    private String turno;
    private String horatrabajada;
    private String horaextra;
    private String horatardanza;
    private String correo;
    private String telefono;
    private String direccion;
    private String genero;
    private String fecnacimiento;
    private String tipoDocumento;
}
