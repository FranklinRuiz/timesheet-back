package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.HorarioModel;
import com.sv.ts.persistence.model.SedeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SedeRepository extends JpaRepository<SedeModel, Long> {
    Page<SedeModel> findByFlgActivoAndNombreSedeContaining(Pageable pageable, boolean flgActivo, String nombre);

    List<SedeModel> findByFlgActivo(boolean flgActivo);
}
