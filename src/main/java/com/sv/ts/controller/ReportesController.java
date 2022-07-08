package com.sv.ts.controller;

import com.sv.ts.persistence.dto.*;
import com.sv.ts.service.ReportesService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/reportes")
@RequiredArgsConstructor

public class ReportesController {
    private final ReportesService reportesService;

    @GetMapping("/rep-general")
    @ApiOperation("Get list - listar reporte general")
    public List<ReporteGeneralDto> getRG(@RequestParam Long IdSede, @RequestParam Long IdTurno) {
        return  reportesService.RepGeneral(IdSede,IdTurno);
    }

    @GetMapping("/rep-turno")
    @ApiOperation("Get list - listar reporte turnos")
    public List<ReporteTurnoDto> getRT(@RequestParam Long IdTurno) {
        return  reportesService.RepTurno(IdTurno);
    }

    @GetMapping("/rep-horas-trabajo")
    @ApiOperation("Get list - listar reporte horas de trabajo")
    public List<ReporteHorasTrabajolDto> getRHT(@RequestParam Long IdSede, @RequestParam String TipoHora) {
        return  reportesService.RepHorasTrabajo(IdSede,TipoHora);
    }

    @GetMapping("/rep-asistencias")
    @ApiOperation("Get list - listar reporte asistencias")
    public List<ReporteAsistenciaDto> getAsistencias() {
        return  reportesService.RepAsistencias();
    }

    @GetMapping("/rep-inasistencias")
    @ApiOperation("Get list - listar reporte inasistencias")
    public List<ReporteInasistenciaDto> getInasistencias() {
        return  reportesService.RepInasistencias();
    }

}
