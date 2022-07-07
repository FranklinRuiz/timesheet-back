package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.IndicadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IndicadorRepository extends JpaRepository<IndicadorModel, Long> {
    @Query(
            value = "call IndDataPersonas(:FInicio, :FFin)"
            , nativeQuery = true
    )
    List<Object[]> SPIndDatosPersonas(String FInicio, String FFin);

    @Query(
            value = "call IndPersonaPorArea(:FInicio, :FFin)"
            , nativeQuery = true
    )
    List<Object[]> SPIndDatosPersonasPorArea(String FInicio, String FFin);

    @Query(
            value = "call IndHorasPorSede(:FInicio, :FFin)"
            , nativeQuery = true
    )
    List<Object[]> SPIndDatosHorasPorSede(String FInicio, String FFin);

}


