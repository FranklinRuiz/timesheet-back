package com.sv.ts.controller;

import com.sv.ts.dto.AsistenciaDto;
import com.sv.ts.service.AsistenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/asistencia")
@RequiredArgsConstructor
public class AsistenciaController {

    private final AsistenciaService asistenciaService;

    @PostMapping("/save")
    public AsistenciaDto save(@Valid @RequestBody AsistenciaDto asistenciaDto) {
        return asistenciaService.saveAsistencia(asistenciaDto);
    }

    @GetMapping(value = "/list")
    public Page<AsistenciaDto> get(Pageable pageable) {
        return asistenciaService.listAllByPage(pageable);
    }

}
