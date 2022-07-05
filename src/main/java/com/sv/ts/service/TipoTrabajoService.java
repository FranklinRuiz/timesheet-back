package com.sv.ts.service;

import com.sv.ts.persistence.dto.TipoTrabajoDto;
import com.sv.ts.persistence.model.TipoTrabajoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TipoTrabajoService {

    TipoTrabajoModel saveTipoTrabajo(TipoTrabajoModel tipoTrabajoModel);

    TipoTrabajoModel updateTipoTrabajo(TipoTrabajoModel tipoTrabajoModel);

    Page<TipoTrabajoDto> listAllByPage(Pageable pageable, String nombre);

    boolean deleteTipoTrabajo(Long idTipoTrabajo);

    List<TipoTrabajoDto> listTipoTrabajo();

}
