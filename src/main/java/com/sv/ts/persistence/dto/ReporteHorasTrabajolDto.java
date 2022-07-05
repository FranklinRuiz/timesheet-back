package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ReporteHorasTrabajolDto {
    private String personal;
    private String sede;
    private String horas;
}
