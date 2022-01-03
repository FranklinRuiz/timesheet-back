package com.timesheet.controller;

import com.timesheet.persistence.entity.DiaFestivo;
import com.timesheet.persistence.entity.TipoTrabajo;
import com.timesheet.service.DiaFestivoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/dia-festivo")
@RequiredArgsConstructor
public class DiaFestivoController {
    private final DiaFestivoService diaFestivoService;

    @GetMapping("/list")
    @ApiOperation("Retorna una lista de todos los objetos tipo Dia Festivo")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Page<DiaFestivo>> get(Pageable pageable) {
        Page<DiaFestivo> c = diaFestivoService.list(pageable);
        return ResponseEntity.ok(c);
    }


    @PostMapping("/save")
    @ApiOperation("Guarda un objeto tipo Dia Festivo")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<DiaFestivo> save(@Valid @RequestBody DiaFestivo dia) {
        return ResponseEntity.ok(diaFestivoService.save(dia));
    }

    @PutMapping("/update")
    @ApiOperation("Actualiza un objeto tipo Dia Festivo")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<DiaFestivo> update(@Valid @RequestBody DiaFestivo dia) {
        return ResponseEntity.ok(diaFestivoService.update(dia));
    }

    @DeleteMapping("/delete/{idDiaFestivo}")
    @ApiOperation("Elimina un objeto Dia Festivo mediante su id")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Long> delete(@PathVariable Long idDiaFestivo) {
        return ResponseEntity.ok(diaFestivoService.delete(idDiaFestivo));
    }

}
