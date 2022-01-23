package com.timesheet.persistence.repository;

import com.timesheet.persistence.entity.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
    Page<Persona> findByFlgActivo(boolean activo, Pageable pageable);
}
