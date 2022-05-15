package com.sv.ts.persistence.model;

import com.sv.ts.utils.Audit;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "horarios")
public class HorarioModel extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;
    private String nombre;
    private String horaInicio;
    private String horaFin;
    private boolean flgActivo;
}
