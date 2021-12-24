package com.timesheet.service;

import com.timesheet.persistence.entity.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CargoService {
    Cargo saveCargo(Cargo cargo);
    Cargo updateCargo(Cargo cargo);
    Page<Cargo> listAllByPage(Pageable pageable);
    Long deleteCargo(Long idCargo);
}
