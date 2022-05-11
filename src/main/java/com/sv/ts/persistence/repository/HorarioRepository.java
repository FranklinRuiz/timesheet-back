package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.HorarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<HorarioModel, Long> {

}
