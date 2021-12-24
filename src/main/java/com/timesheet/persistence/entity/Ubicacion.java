package com.timesheet.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.timesheet.utils.Auditoria;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ubicacion")
public class Ubicacion extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbicacion;
    private String nombreSede;
    private String descripcion;
    private String direccion;
    private String coordLong;
    private String coordLat;
    @JsonIgnore
    private boolean flgActivo;
}
