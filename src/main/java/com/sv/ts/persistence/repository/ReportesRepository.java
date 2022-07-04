package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.ReporteGeneralModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportesRepository extends JpaRepository<ReporteGeneralModel, Long> {
    @Query(
            value = "call RepGeneral(:IdSede, :IdTurno)"
            , nativeQuery = true
    )
    List<Object[]> SPRepGeneral(Long IdSede, Long IdTurno);

    @Query(
            value = "call RepTurno(:IdTurno)"
            , nativeQuery = true
    )
    List<Object[]> SPRepTurno(Long IdTurno);

    @Query(
            value = "call RepHorasDeTrabajo(:IdSede,:TipoHora)"
            , nativeQuery = true
    )
    List<Object[]> SPRepHorasDeTrabajo(Long IdSede, String TipoHora);

}
