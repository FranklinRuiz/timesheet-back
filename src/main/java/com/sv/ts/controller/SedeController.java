package com.sv.ts.controller;

import com.sv.ts.dto.HorarioDto;
import com.sv.ts.dto.SedeDto;
import com.sv.ts.persistence.model.HorarioModel;
import com.sv.ts.persistence.model.SedeModel;
import com.sv.ts.service.SedeService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/sede")
@RequiredArgsConstructor

public class SedeController {
    private final SedeService sedeService;

    @PostMapping("/save")
    @ApiOperation("Post save - registrar nueva sede")
    public SedeModel save(@Valid @RequestBody SedeModel sedeModel) {
        return sedeService.saveSede(sedeModel);
    }

    @GetMapping("/list")
    @ApiOperation("Get list - Lista todos las sedes")
    public Page<SedeDto> get(Pageable pageable, @RequestParam String nombre) {
        return sedeService.listAllByPage(pageable, nombre);
    }

    @PutMapping("/update")
    @ApiOperation("Put update - actualizar sede")
    public SedeModel update(@Valid @RequestBody SedeModel sedeModel) {
        return sedeService.updateSede(sedeModel);
    }

    @DeleteMapping("/delete/{idSede}")
    @ApiOperation("Delete - elimina Horario mediante un ID")
    public Boolean delete(@PathVariable Long idSede) {
        return sedeService.deleteSede(idSede);
    }

    @GetMapping("/list-all")
    @ApiOperation("Get list - Lista todos las sedes")
    public List<SedeDto> getAll() {
        return sedeService.listSede();
    }

}
