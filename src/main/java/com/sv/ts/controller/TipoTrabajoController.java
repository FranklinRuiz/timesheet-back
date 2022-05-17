package com.sv.ts.controller;

import com.sv.ts.dto.TipoTrabajoDto;
import com.sv.ts.persistence.model.TipoTrabajoModel;
import com.sv.ts.service.TipoTrabajoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/tipo-trabajo")
@RequiredArgsConstructor

public class TipoTrabajoController {
    private final TipoTrabajoService tipoTrabajoService;

    @PostMapping("/save")
    @ApiOperation("Post save - registrar nueva tipo de trabajo")
    public TipoTrabajoModel save(@Valid @RequestBody TipoTrabajoModel tipoTrabajoModel) {
        return tipoTrabajoService.saveTipoTrabajo(tipoTrabajoModel);
    }

    @GetMapping("/list")
    @ApiOperation("Get list - Lista todos los tipo de trabajo")
    public Page<TipoTrabajoDto> get(Pageable pageable, @RequestParam String nombre) {
        return tipoTrabajoService.listAllByPage(pageable, nombre);
    }

    @PutMapping("/update")
    @ApiOperation("Put update - actualizar tipo trabajo")
    public TipoTrabajoModel update(@Valid @RequestBody TipoTrabajoModel tipoTrabajoModel) {
        return tipoTrabajoService.updateTipoTrabajo(tipoTrabajoModel);
    }

    @DeleteMapping("/delete/{idTipoTrabajo}")
    @ApiOperation("Delete - elimina Tipo trabajo mediante un ID")
    public Boolean delete(@PathVariable Long idTipoTrabajo) {
        return tipoTrabajoService.deleteTipoTrabajo(idTipoTrabajo);
    }

    @GetMapping("/list-all")
    @ApiOperation("Get list - Lista todos los tipos de trabajo")
    public List<TipoTrabajoDto> getAll() {
        return tipoTrabajoService.listTipoTrabajo();
    }


}
