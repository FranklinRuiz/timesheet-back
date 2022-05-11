package com.sv.ts.persistence.model;

import com.sv.ts.utils.Audit;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "dias_festivos")
public class DiaFestivoModel extends Audit<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiaFestivo;
    private String nombreDiaFestivo;
    private LocalDate fechaDiaFestivo;
    private boolean flgActivo;
}
