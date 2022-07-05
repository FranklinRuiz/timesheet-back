package com.sv.ts.service;

import com.sv.ts.dto.AsistenciaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AsistenciaService {
    AsistenciaDto saveAsistencia(AsistenciaDto asistencia);

    AsistenciaDto getAsistencia(Long idEmpleado);

    Page<AsistenciaDto> listAllByPage(Pageable pageable);
}
