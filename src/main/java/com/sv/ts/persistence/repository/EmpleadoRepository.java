package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.EmpleadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<EmpleadoModel, Long> {

}
