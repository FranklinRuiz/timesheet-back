package com.sv.ts.service;

import com.sv.ts.dto.PersonalDto;
import com.sv.ts.dto.TempDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonalService {
    PersonalDto savePersonal(PersonalDto personal);

    PersonalDto updatePersonal(PersonalDto personal);

    Page<PersonalDto> listAllByPage(Pageable pageable, String nombre);

    boolean deletePersonal(Long idPersonal);

    List<TempDto> listTipoDocumento();

    List<TempDto> listTipoGenero();
}
