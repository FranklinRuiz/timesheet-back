package com.timesheet.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.timesheet.utils.Auditoria;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "personas")
public class Persona extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private Integer tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String sexo;
    private String nombreCompleto;
    @JsonIgnore
    private boolean flgActivo;
}
