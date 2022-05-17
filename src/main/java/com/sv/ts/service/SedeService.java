package com.sv.ts.service;

import com.sv.ts.dto.SedeDto;
import com.sv.ts.persistence.model.SedeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SedeService {
    SedeModel saveSede(SedeModel sedeModel);

    SedeModel updateSede(SedeModel sedeModel);

    Page<SedeDto> listAllByPage(Pageable pageable, String nombre);

    boolean deleteSede(Long idSede);

    List<SedeDto> listSede();
}
