package com.sv.ts.service;

import com.sv.ts.persistence.dto.IndicadoresDto;
import com.sv.ts.persistence.dto.IndicadoresHorasPorSedeDto;
import com.sv.ts.persistence.dto.IndicadoresPersonaPorAreaDto;

import java.util.List;

public interface IndicadorService {
    List<IndicadoresDto>  IndDatosPersonas();
    List<IndicadoresPersonaPorAreaDto>  IndDatosPersonasPorAreas();
    List<IndicadoresHorasPorSedeDto>  IndDatosHorasPorSedes();
}
