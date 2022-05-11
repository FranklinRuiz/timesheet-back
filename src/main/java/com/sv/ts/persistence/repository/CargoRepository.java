package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.CargoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<CargoModel, Long> {
    Page<CargoModel> findByFlgActivoAndNombreCargoContaining(Pageable pageable, boolean flgActivo, String nombre);
}