package com.timesheet.service;

import com.timesheet.persistence.entity.Horario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HorarioService {
    Horario saveHorario(Horario horario);
    Horario updateHorario(Horario horario);
    Page<Horario> listAllByPage(Pageable pageable);
    Long deleteHorario(Long idHorario);
}
