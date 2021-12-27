package com.timesheet.controller;

import com.timesheet.persistence.entity.Cargo;
import com.timesheet.service.CargoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<Cargo> save(@Valid @RequestBody Cargo cargo) {
        return ResponseEntity.ok(cargoService.saveCargo(cargo));
    }

    @PutMapping("/update")
    @ApiOperation("Put update - actualiza datos de cargo")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Cargo> update(@Valid @RequestBody Cargo cargo) {
        return ResponseEntity.ok(cargoService.updateCargo(cargo));
    }

    @GetMapping("/list")
    @ApiOperation("Get list - lista todos los cargos registrados")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Page<Cargo>> get(Pageable pageable) {
        Page<Cargo> c = cargoService.listAllByPage(pageable);
        return ResponseEntity.ok(c);
    }

    @DeleteMapping("/delete/{idCargo}")
    @ApiOperation("Delete - elimina cargo registrado")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Long> delete(@PathVariable Long idCargo) {
        return ResponseEntity.ok(cargoService.deleteCargo(idCargo));
    }
}
