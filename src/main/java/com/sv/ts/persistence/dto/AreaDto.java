package com.sv.ts.persistence.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AreaDto {
    private Long idArea;
    private String codigoArea;
    private String nombreArea;
}
