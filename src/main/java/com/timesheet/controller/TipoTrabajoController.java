package com.timesheet.controller;

import com.timesheet.persistence.entity.Cargo;
import com.timesheet.persistence.entity.TipoTrabajo;
import com.timesheet.service.TipoTrabajoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/tipo-trabajo")
@RequiredArgsConstructor
public class TipoTrabajoController {

    private final TipoTrabajoService tipoTrabajoService;

    @GetMapping("/list")
    @ApiOperation("Get list - descripcion del servicio")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Page<TipoTrabajo>> get(Pageable pageable) {
        Page<TipoTrabajo> c = tipoTrabajoService.list(pageable);
        return ResponseEntity.ok(c);
    }

    @PostMapping("/save")
    @ApiOperation("Post save - ...")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<TipoTrabajo> save(@Valid @RequestBody TipoTrabajo tipo) {
        return ResponseEntity.ok(tipoTrabajoService.save(tipo));
    }

    @PutMapping("/update")
    @ApiOperation("Put update - ...")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<TipoTrabajo> update(@Valid @RequestBody TipoTrabajo tipo) {
        return ResponseEntity.ok(tipoTrabajoService.update(tipo));
    }

    @DeleteMapping("/delete/{idTipoTrabajo}")
    @ApiOperation("Delete - ...")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Long> delete(@PathVariable Long idTipoTrabajo) {
        return ResponseEntity.ok(tipoTrabajoService.delete(idTipoTrabajo));
    }
}
