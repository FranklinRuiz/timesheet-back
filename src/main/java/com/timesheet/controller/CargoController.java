package com.timesheet.controller;

import com.timesheet.handler.ResponseHandler;
import com.timesheet.persistence.entity.Cargo;
import com.timesheet.service.CargoService;
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
@RequestMapping("/api/cargo")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService cargoService;

    @PostMapping("/save")
    @ApiOperation("Post save - guarda datos de nuevo cargo")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> save(@Valid @RequestBody Cargo cargo) {
        try {
            Cargo result = cargoService.saveCargo(cargo);
            return ResponseHandler.generateResponse("Datos registrados con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/update")
    @ApiOperation("Put update - actualiza datos de cargo")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> update(@Valid @RequestBody Cargo cargo) {
        try {
            Cargo result = cargoService.updateCargo(cargo);
            return ResponseHandler.generateResponse("Datos actualizados con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/list")
    @ApiOperation("Get list - lista todos los cargos registrados")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> get(Pageable pageable) {
        try {
            Page<Cargo> c = cargoService.listAllByPage(pageable);
            return ResponseHandler.generateResponse("Datos listados con exito!", HttpStatus.OK, c);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/delete/{idCargo}")
    @ApiOperation("Delete - elimina cargo registrado")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Object> delete(@PathVariable Long idCargo) {
        try {
            Long result = cargoService.deleteCargo(idCargo);
            return ResponseHandler.generateResponse("Dato eliminado con exito!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
