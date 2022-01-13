package com.timesheet.controller;

import com.timesheet.handler.ResponseHandler;
import com.timesheet.persistence.entity.Horario;
import com.timesheet.service.HorarioService;
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
@RequestMapping("/api/horario")
@RequiredArgsConstructor
public class HorarioController {
    private final HorarioService horarioService;

    @PostMapping("/save")
    @ApiOperation("Post save - Guarda un objeto tipo Horario")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> save(@Valid @RequestBody Horario horario) {
        try {
            Horario result = horarioService.saveHorario(horario);
            return ResponseHandler.generateResponse("Horario registrado con éxito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/list")
    @ApiOperation("Get list - Retorna todos los horarios registrados")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> get(Pageable pageable) {
        try {
            Page<Horario> c = horarioService.listAllByPage(pageable);
            return ResponseHandler.generateResponse("Horarios listados con éxito!", HttpStatus.OK, c);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/update")
    @ApiOperation("Put update - actualiza un objeto tipo horario")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> update(@Valid @RequestBody Horario horario) {
        try {
            Horario result = horarioService.updateHorario(horario);
            return ResponseHandler.generateResponse("Horario actializado con éxito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/delete/{idHorario}")
    @ApiOperation("Delete - Elimina un objeto tipo horario")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> delete(@PathVariable Long idHorario) {
        try {
            Long result = horarioService.deleteHorario(idHorario);
            return ResponseHandler.generateResponse("Horario eliminado con éxito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}