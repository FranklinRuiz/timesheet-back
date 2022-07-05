package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReporteTurnoDto {
    private String personal;
    private String turno;
    private String hinicio;
    private String hfin;
}
