package com.sv.ts.controller;

import com.sv.ts.persistence.dto.IndicadoresDto;
import com.sv.ts.persistence.dto.IndicadoresHorasPorSedeDto;
import com.sv.ts.persistence.dto.IndicadoresPersonaPorAreaDto;
import com.sv.ts.service.IndicadorService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/indicador")
@RequiredArgsConstructor

public class IndicadoresController {
    private final IndicadorService indicadorService;

    @GetMapping("/datos-personas")
    @ApiOperation("Get list - lista total de personas y total por genero")
    public List<IndicadoresDto> getPersonas() {
        return indicadorService.IndDatosPersonas();
    }

    @GetMapping("/datos-personas-por-area")
    @ApiOperation("Get list - lista total de personas por area")
    public List<IndicadoresPersonaPorAreaDto> getPersonasxArea() {
        return indicadorService.IndDatosPersonasPorAreas();
    }

    @GetMapping("/datos-horas-por-sede")
    @ApiOperation("Get list - lista horas por sede")
    public List<IndicadoresHorasPorSedeDto> getHorasxSede() {
        return indicadorService.IndDatosHorasPorSedes();
    }
}
