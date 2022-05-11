package com.sv.ts.persistence.model;

import com.sv.ts.utils.Audit;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "asistencia")
public class AsistenciaModel extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsistencia;
    private Long idEmpleado;
    private Integer idTipoTrabajo;
    private Integer idUbicacion;
    private Integer idDispositivo;
    private String horaEntrada;
    private String horaSalida;
    private String coordLong;
    private String coordLat;
    private boolean flgDiaFestivo;
    private boolean flgactivo;
}
