package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.SedeModel;
import com.sv.ts.persistence.model.TipoTrabajoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoTrabajoRepository extends JpaRepository<TipoTrabajoModel, Long> {
    Page<TipoTrabajoModel> findByFlgActivoAndNombreTipoTrabajoContaining(Pageable pageable, boolean flgActivo, String nombre);

    List<TipoTrabajoModel> findByFlgActivo(boolean flgActivo);
}
