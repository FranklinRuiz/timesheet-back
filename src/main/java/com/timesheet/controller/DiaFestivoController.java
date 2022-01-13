package com.timesheet.controller;

import com.timesheet.handler.ResponseHandler;
import com.timesheet.persistence.entity.DiaFestivo;
import com.timesheet.service.DiaFestivoService;
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
@RequestMapping("api/dia-festivo")
@RequiredArgsConstructor
public class DiaFestivoController {
    private final DiaFestivoService diaFestivoService;

    @PostMapping("/save")
    @ApiOperation("Guarda un objeto tipo Dia Festivo")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> save(@Valid @RequestBody DiaFestivo dia) {
        try {
            DiaFestivo result = diaFestivoService.saveDiaFestivo(dia);
            return ResponseHandler.generateResponse("Dia festivo registrado con éxito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/list")
    @ApiOperation("Retorna una lista de todos los objetos tipo Dia Festivo")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> get(Pageable pageable) {
        try {
            Page<DiaFestivo> c = diaFestivoService.listAllByPage(pageable);
            return ResponseHandler.generateResponse("Dias festivos listados con éxito!", HttpStatus.OK, c);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/update")
    @ApiOperation("Actualiza un objeto tipo Dia Festivo")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> update(@Valid @RequestBody DiaFestivo dia) {
        try {
            DiaFestivo result = diaFestivoService.updateDiaFestivo(dia);
            return ResponseHandler.generateResponse("Dia festivo actualizados con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/delete/{idDiaFestivo}")
    @ApiOperation("Elimina un objeto Dia Festivo mediante su id")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> delete(@PathVariable Long idDiaFestivo) {
        try {
            Long result = diaFestivoService.deleteDiaFestivo(idDiaFestivo);
            return ResponseHandler.generateResponse("Dia Festivo eliminado con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}