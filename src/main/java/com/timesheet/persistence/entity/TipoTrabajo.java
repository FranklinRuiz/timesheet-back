package com.timesheet.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.timesheet.utils.Auditoria;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tipo_trabajo")
public class TipoTrabajo extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoTrabajo;
    private String nombreTipoTrabajo;
    private String abreviatura;
    @JsonIgnore
    private boolean flgActivo;
}
