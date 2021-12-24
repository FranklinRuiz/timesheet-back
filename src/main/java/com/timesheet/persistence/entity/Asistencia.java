package com.timesheet.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.timesheet.utils.Auditoria;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "asistencia")
public class Asistencia extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsistencia;
    private Long idEmpleado;
    private Long idTipoTrabajo;
    private Long idUbicacion;
    private Long idDispositivo;
    private String horaEntrada;
    private String horaSalida;
    private String coordLong;
    private String coordLat;
    private boolean flgDiaFestivo;
    @JsonIgnore
    private boolean flgActivo;
}
