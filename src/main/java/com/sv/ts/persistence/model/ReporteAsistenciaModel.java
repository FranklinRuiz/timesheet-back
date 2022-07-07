package com.sv.ts.persistence.model;

import com.sv.ts.utils.Audit;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "asistencia")

public class ReporteAsistenciaModel  extends Audit<String>  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsistencia;
    private String empleado;
    private String hentrada;
    private String hsalida;

}

