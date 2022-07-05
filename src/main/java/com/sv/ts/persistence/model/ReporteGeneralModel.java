package com.sv.ts.persistence.model;

import com.sv.ts.utils.Audit;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "personas")
public class ReporteGeneralModel extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String personal;
    private String area;
    private String cargo;
    private String sede;
    private String hentrada;
    private String hsalida;
    private String turno;
    private String horatrabajada;
    private String horaextra;
    private String horatardanza;
    private String correo;
    private String telefono;
    private String direccion;
    private String genero;
    private String fecnacimiento;
    private String tipoDocumento;
}
