package com.timesheet.service;

import com.timesheet.persistence.entity.TipoTrabajo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TipoTrabajoService {
    TipoTrabajo save(TipoTrabajo tipoTrabajo);
    TipoTrabajo update(TipoTrabajo tipoTrabajo);
    Page<TipoTrabajo> list(Pageable pageable);
    Long delete(Long idTipoTrabajo);
}
