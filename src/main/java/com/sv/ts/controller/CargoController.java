package com.sv.ts.controller;

import com.sv.ts.dto.CargoDto;
import com.sv.ts.persistence.model.CargoModel;
import com.sv.ts.service.CargoService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/cargo")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService cargoService;

    //    @RolesAllowed({"admin", "user"})
    @PostMapping("/save")
    @ApiOperation("Post save - registrar nuevo cargo")
    public CargoModel save(@Valid @RequestBody CargoModel cargoModel) {
        return cargoService.saveCargo(cargoModel);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Get list - Lista todos los cargos")
    public Page<CargoDto> get(Pageable pageable, @RequestParam String nombre) {
        return cargoService.listAllByPage(pageable, nombre);
    }

    @PutMapping("/update")
    @ApiOperation("Put update - actualizar cargo")
    public CargoModel update(@Valid @RequestBody CargoModel cargoModel) throws Exception {
        return cargoService.updateCargo(cargoModel);
    }

    @DeleteMapping("/delete/{idCargo}")
    @ApiOperation("Delete - elimina cargo mediante un ID")
    public Boolean delete(@PathVariable Long idCargo) throws Exception {
        return cargoService.deleteCargo(idCargo);
    }

}
