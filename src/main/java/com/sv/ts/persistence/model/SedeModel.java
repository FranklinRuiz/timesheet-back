package com.sv.ts.persistence.model;

import com.sv.ts.utils.Audit;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sedes")
public class SedeModel extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSede;
    private String nombreSede;
    private String descripcion;
    private String direccion;
    private String coordLong;
    private String coordLat;
    private boolean flgActivo;
}
