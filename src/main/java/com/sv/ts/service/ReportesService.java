package com.sv.ts.service;

import com.sv.ts.persistence.dto.*;

import java.util.List;

public interface ReportesService {
    List<ReporteGeneralDto> RepGeneral(Long IdSede, Long IdTurno);
    List<ReporteHorasTrabajolDto> RepHorasTrabajo(Long IdSede, String TipoHora);
    List<ReporteTurnoDto> RepTurno(Long IdTurno);
    List<ReporteAsistenciaDto> RepAsistencias();
    List<ReporteInasistenciaDto> RepInasistencias();

}
