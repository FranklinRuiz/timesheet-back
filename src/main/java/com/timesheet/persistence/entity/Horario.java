package com.timesheet.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.timesheet.utils.Auditoria;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "horarios")
public class Horario extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;
    private String horaInicio;
    private String horaFin;
    @JsonIgnore
    private boolean flgActivo;
}
