package com.sv.ts.service;

import com.sv.ts.dto.HorarioDto;
import com.sv.ts.persistence.model.HorarioModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HorarioService {
    HorarioModel saveHorario(HorarioModel Horario);

    HorarioModel updateHorario(HorarioModel Horario);

    Page<HorarioDto> listAllByPage(Pageable pageable, String nombre);

    boolean deleteHorario(Long idHorario);

    List<HorarioDto> listHorario();
}
