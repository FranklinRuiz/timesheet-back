package com.timesheet.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.timesheet.utils.Auditoria;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cargos")
public class Cargo extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCargo;
    private String codigoCargo;
    private String nombreCargo;
    @JsonIgnore
    private boolean flgActivo;

}
