package com.timesheet.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.timesheet.utils.Auditoria;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dispositivos")
public class Dispositivo extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDispositivo;
    private String nombreDispotivo;
    private String ipDispositivo;
    private String serie;
    private String codigo;
    private String modelo;
    private String marca;
    @JsonIgnore
    private boolean flgActivo;
}
