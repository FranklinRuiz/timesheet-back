package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.EmpleadoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpleadoRepository extends JpaRepository<EmpleadoModel, Long> {
    @Query("select e,p.tipoDocumento,p.numeroDocumento,p.nombres,p.apellidoPaterno,p.apellidoMaterno,p.fechaNacimiento,p.sexo,p.nombreCompleto,c.nombreCargo,concat(o.nombre,' | ',o.horaInicio,' - ',o.horaFin) as horario from EmpleadoModel e " +
            "inner join PersonaModel p on e.idPersona = p.idPersona " +
            "inner join CargoModel c on e.idCargo = c.idCargo " +
            "inner join HorarioModel o on e.idHorario = o.idHorario " +
            "where p.nombreCompleto like %:nombre% and e.flgActivo = :activo ")
    Page<Object[]> findAllByPage(@Param("nombre") String nombre, @Param("activo") Boolean activo, Pageable page);
}
