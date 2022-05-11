package com.sv.ts.persistence.model;

import com.sv.ts.utils.Audit;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "dispositivos")
public class DispositivoModel extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDispositivo;
    private String nombreDispotivo;
    private String ipDispositivo;
    private String serie;
    private String codigo;
    private String modelo;
    private String marca;
    private boolean flgActivo;
}
