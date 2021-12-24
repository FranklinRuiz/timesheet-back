package com.timesheet.persistence.repository;

import com.timesheet.persistence.entity.TipoTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTrabajoRepository extends JpaRepository<TipoTrabajo,Long> {
}
