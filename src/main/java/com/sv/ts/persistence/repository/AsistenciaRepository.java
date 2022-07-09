package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.AsistenciaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AsistenciaRepository extends JpaRepository<AsistenciaModel, Long> {
    @Query("select a,t.abreviatura,p.nombreCompleto from AsistenciaModel a " +
            "inner join EmpleadoModel e on e.idEmpleado = a.idEmpleado " +
            "inner join TipoTrabajoModel t on t.idTipoTrabajo = a.idTipoTrabajo " +
            "inner join PersonaModel p on p.idPersona = e.idPersona " +
            "where e.flgActivo = :activo and a.horaEntrada is not null ")
    Page<Object[]> findAllByPage(@Param("activo") Boolean activo, Pageable page);
}
