package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.PersonaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaModel, Long> {

}
