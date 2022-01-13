package com.timesheet.persistence.repository;

import com.timesheet.persistence.entity.Horario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Long> {
    Page<Horario> findByFlgActivo(boolean activo, Pageable pageable);
}
