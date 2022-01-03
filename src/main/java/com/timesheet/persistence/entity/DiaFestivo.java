package com.timesheet.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.timesheet.utils.Auditoria;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "dias_festivos")
public class DiaFestivo extends Auditoria<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiaFestivo;
    private String nombreDiaFestivo;
    private Date fecha;
    @JsonIgnore
    private boolean flgActivo;
}
