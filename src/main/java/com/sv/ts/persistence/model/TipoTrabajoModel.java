package com.sv.ts.persistence.model;

import com.sv.ts.utils.Audit;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tipo_trabajo")
public class TipoTrabajoModel extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoTrabajo;
    private String nombreTipoTrabajo;
    private String abreviatura;
    private boolean flgActivo;
}
