package com.sv.ts.controller;

import com.sv.ts.dto.PersonalDto;
import com.sv.ts.dto.TempDto;
import com.sv.ts.service.PersonalService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/personal")
@RequiredArgsConstructor
public class PersonalController {

    private final PersonalService personalService;

    @PostMapping("/save")
    @ApiOperation("Post save - registrar nuevo personal")
    public PersonalDto save(@Valid @RequestBody PersonalDto personalDto) {
        return personalService.savePersonal(personalDto);
    }

    @GetMapping("/list")
    @ApiOperation("Get list - lista todos los personal")
    public Page<PersonalDto> get(Pageable pageable, @RequestParam String nombre) {
        return personalService.listAllByPage(pageable, nombre);
    }

    @PutMapping("/update")
    @ApiOperation("Put update - actualizar personal")
    public PersonalDto update(@Valid @RequestBody PersonalDto personalDto) {
        return personalService.updatePersonal(personalDto);
    }

    @DeleteMapping("/delete/{idPersonal}")
    @ApiOperation("Delete - elimina personal mediante un ID")
    public Boolean delete(@PathVariable Long idPersonal) {
        return personalService.deletePersonal(idPersonal);
    }

    @GetMapping("/list-tipo-documento")
    @ApiOperation("Get list - lista tipos de documento")
    public List<TempDto> getTipoDocumento() {
        return personalService.listTipoDocumento();
    }

    @GetMapping("/list-tipo-genero")
    @ApiOperation("Get list - lista tipos de genero")
    public List<TempDto> getTipoGenero() {
        return personalService.listTipoGenero();
    }
}
