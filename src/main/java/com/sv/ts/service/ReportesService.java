package com.sv.ts.service;

import com.sv.ts.persistence.dto.ReporteGeneralDto;
import com.sv.ts.persistence.dto.ReporteHorasTrabajolDto;
import com.sv.ts.persistence.dto.ReporteTurnoDto;

import java.util.List;

public interface ReportesService {
    List<ReporteGeneralDto> RepGeneral(Long IdSede, Long IdTurno);
    List<ReporteHorasTrabajolDto> RepHorasTrabajo(Long IdSede, String TipoHora);
    List<ReporteTurnoDto> RepTurno(Long IdTurno);

}
