package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.IndicadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IndicadorRepository extends JpaRepository<IndicadorModel, Long> {
    @Query(
            value = "call IndDataPersonas()"
            , nativeQuery = true
    )
    List<Object[]> SPIndDatosPersonas();

    @Query(
            value = "call IndPersonaPorArea()"
            , nativeQuery = true
    )
    List<Object[]> SPIndDatosPersonasPorArea();

    @Query(
            value = "call IndHorasPorSede()"
            , nativeQuery = true
    )
    List<Object[]> SPIndDatosHorasPorSede();

}


