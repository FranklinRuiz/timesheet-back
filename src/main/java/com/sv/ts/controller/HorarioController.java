package com.sv.ts.controller;

import com.sv.ts.persistence.dto.HorarioDto;
import com.sv.ts.persistence.model.HorarioModel;
import com.sv.ts.service.HorarioService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/horario")
@RequiredArgsConstructor
public class HorarioController {

    private final HorarioService horarioService;

    //    @RolesAllowed({"admin", "user"})
    @PostMapping("/save")
    @ApiOperation("Post save - registrar nuevo Horario")
    public HorarioModel save(@Valid @RequestBody HorarioModel horarioModel) {
        return horarioService.saveHorario(horarioModel);
    }

    @GetMapping("/list")
    @ApiOperation("Get list - Lista todos los Horarios")
    public Page<HorarioDto> get(Pageable pageable, @RequestParam String nombre) {
        return horarioService.listAllByPage(pageable, nombre);
    }

    @PutMapping("/update")
    @ApiOperation("Put update - actualizar Horario")
    public HorarioModel update(@Valid @RequestBody HorarioModel horarioModel) {
        return horarioService.updateHorario(horarioModel);
    }

    @DeleteMapping("/delete/{idHorario}")
    @ApiOperation("Delete - elimina Horario mediante un ID")
    public Boolean delete(@PathVariable Long idHorario) {
        return horarioService.deleteHorario(idHorario);
    }

    @GetMapping("/list-all")
    @ApiOperation("Get list - Lista todos los Horarios")
    public List<HorarioDto> getAll() {
        return horarioService.listHorario();
    }
}
