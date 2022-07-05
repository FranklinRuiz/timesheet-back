package com.sv.ts.persistence.model;

import com.sv.ts.utils.Audit;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "empleados")
public class EmpleadoModel extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;
    private Long idPersona;
    private Long idArea;
    private Long idCargo;
    private Long idHorario;
    private String codigoEmpleado;
    private String telefono;
    private String correo;
    private String direccion;
    private String foto;
    private boolean flgActivo;
}
