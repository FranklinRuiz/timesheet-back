package com.timesheet.service;

import com.timesheet.persistence.entity.TipoTrabajo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TipoTrabajoService {
    TipoTrabajo saveTipoTrabajo(TipoTrabajo tipoTrabajo);
    TipoTrabajo updateTipoTrabajo(TipoTrabajo tipoTrabajo);
    Page<TipoTrabajo> listAllByPage(Pageable pageable);
    Long deleteTipoTrabajo(Long idTipoTrabajo);
}
