package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.CargoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CargoRepository extends JpaRepository<CargoModel, Long> {
    Page<CargoModel> findByFlgActivoAndNombreCargoContaining(Pageable pageable, boolean flgActivo, String nombre);

    List<CargoModel> findByFlgActivo(boolean flgActivo);

    CargoModel findByNombreCargoAndFlgActivo(String nombre, boolean flg);

}
