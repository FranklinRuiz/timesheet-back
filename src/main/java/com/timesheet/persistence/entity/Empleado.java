package com.timesheet.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.timesheet.utils.Auditoria;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "empleados")
public class Empleado extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;
    private Long idPersona;
    private Long idCargo;
    private Long idHorario;
    private String codigoEmpleado;
    private String telefono;
    private String correo;
    private String direccion;
    private String foto;
    @JsonIgnore
    private boolean flgActivo;

}
