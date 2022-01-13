package com.timesheet.controller;

import com.timesheet.handler.ResponseHandler;
import com.timesheet.persistence.entity.Cargo;
import com.timesheet.persistence.entity.TipoTrabajo;
import com.timesheet.service.TipoTrabajoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/tipo-trabajo")
@RequiredArgsConstructor
public class TipoTrabajoController {

    private final TipoTrabajoService tipoTrabajoService;

    @PostMapping("/save")
    @ApiOperation("Post save - Guarda un objeto tipo trabajo")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> save(@Valid @RequestBody TipoTrabajo tipo) {
        try {
            TipoTrabajo result = tipoTrabajoService.saveTipoTrabajo(tipo);
            return ResponseHandler.generateResponse("Tipo Trabajo registrado con éxito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/list")
    @ApiOperation("Get list - Lista todos los tipos de trabajo registrados")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> get(Pageable pageable) {
        try {
            Page<TipoTrabajo> c = tipoTrabajoService.listAllByPage(pageable);
            return ResponseHandler.generateResponse("Tipos de trabajo listados con éxito!", HttpStatus.OK, c);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/update")
    @ApiOperation("Put update - Actualiza un objeto de tipo trabajo")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> update(@Valid @RequestBody TipoTrabajo tipo) {
        try {
            TipoTrabajo result = tipoTrabajoService.updateTipoTrabajo(tipo);
            return ResponseHandler.generateResponse("Tipo de Trabajo actualizado con éxito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/delete/{idTipoTrabajo}")
    @ApiOperation("Delete - Elimina un objeto de tipo trabajo mediante un ID")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> delete(@PathVariable Long idTipoTrabajo) {
        try {
            Long result = tipoTrabajoService.deleteTipoTrabajo(idTipoTrabajo);
            return ResponseHandler.generateResponse("Tipo de Trabajo eliminado con éxito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
