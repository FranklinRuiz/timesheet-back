package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PersonalDto {
    private Long idEmpleado;
    private String codigoEmpleado;
    private Integer tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String nombreCompleto;
    private Long idCargo;
    private String cargo;
    private Long idHorario;
    private String horario;
    private String telefono;
    private String correo;
    private String direccion;
    private String foto;
    private Long idArea;
}
