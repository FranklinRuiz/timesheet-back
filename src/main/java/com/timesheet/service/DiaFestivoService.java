package com.timesheet.service;

import com.timesheet.persistence.entity.DiaFestivo;
import com.timesheet.persistence.entity.TipoTrabajo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiaFestivoService {
    DiaFestivo save(DiaFestivo diaFestivo);
    DiaFestivo update(DiaFestivo diaFestivo);
    Page<DiaFestivo> list(Pageable pageable);
    Long delete(Long idDiaFestivo);
}
