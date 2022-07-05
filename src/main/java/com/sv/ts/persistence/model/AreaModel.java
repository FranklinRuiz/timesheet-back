package com.sv.ts.persistence.model;
import com.sv.ts.utils.Audit;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "areas")

public class AreaModel extends Audit <String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;
    private String codigoArea;
    private String nombreArea;
    private boolean flgActivo;
}
