package com.timesheet.persistence.repository;

import com.timesheet.persistence.entity.TipoTrabajo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTrabajoRepository extends JpaRepository<TipoTrabajo,Long> {
    Page<TipoTrabajo> findByFlgActivo(boolean activo, Pageable pageable);
}
