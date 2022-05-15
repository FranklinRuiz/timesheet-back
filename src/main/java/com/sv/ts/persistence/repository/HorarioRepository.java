package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.HorarioModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorarioRepository extends JpaRepository<HorarioModel, Long> {
    Page<HorarioModel> findByFlgActivoAndNombreContaining(Pageable pageable, boolean flgActivo, String nombre);

    List<HorarioModel> findByFlgActivo(boolean flgActivo);
}
