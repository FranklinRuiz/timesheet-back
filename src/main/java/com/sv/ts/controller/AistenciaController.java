package com.sv.ts.controller;

import com.sv.ts.persistence.model.AsistenciaModel;
import com.sv.ts.service.AsistenciaService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/asistencia")
@RequiredArgsConstructor

public class AistenciaController {
    private final AsistenciaService asistenciaService;

    @PostMapping("/save")
    @ApiOperation("Post save - registrar nueva asistencia")
    public boolean save(@Valid @RequestBody List<AsistenciaModel> asistenciaModels){
        return asistenciaService.save(asistenciaModels);
    }
}
