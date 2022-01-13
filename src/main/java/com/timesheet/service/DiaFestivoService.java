package com.timesheet.service;

import com.timesheet.persistence.entity.DiaFestivo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiaFestivoService {
    DiaFestivo saveDiaFestivo(DiaFestivo diaFestivo);
    DiaFestivo updateDiaFestivo(DiaFestivo diaFestivo);
    Page<DiaFestivo> listAllByPage(Pageable pageable);
    Long deleteDiaFestivo(Long idDiaFestivo);
}
