package com.sv.ts.controller;

import com.sv.ts.persistence.dto.AreaDto;
import com.sv.ts.persistence.model.AreaModel;
import com.sv.ts.service.AreaService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/area")
@RequiredArgsConstructor

public class AreaController {
    private final AreaService areaService;

    @PostMapping("/save")
    @ApiOperation("Post save - registrar nuevo area")
    public AreaModel save (@Valid @RequestBody AreaModel areaModel){
        return  areaService.saveArea(areaModel);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Get list - Lista todos las areas")
    public Page<AreaDto> get(Pageable pageable, @RequestParam Long idArea) {
        return areaService.listAllByPage(pageable, idArea);
    }

    @PutMapping("/update")
    @ApiOperation("Put update - actualizar area")
    public AreaModel update(@Valid @RequestBody AreaModel areaModel) throws Exception {
        return areaService.updateArea(areaModel);
    }

    @DeleteMapping("/delete/{idArea}")
    @ApiOperation("Delete - elimina area mediante un ID")
    public Boolean delete(@PathVariable Long idArea) throws Exception {
        return areaService.deleteArea(idArea);
    }

    @GetMapping(value = "/list-all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Get list - Lista todos los areas")
    public List<AreaDto> getAll() {
        return areaService.listArea();
    }
}
