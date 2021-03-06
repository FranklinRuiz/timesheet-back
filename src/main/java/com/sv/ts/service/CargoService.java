package com.sv.ts.service;

import com.sv.ts.persistence.dto.CargoDto;
import com.sv.ts.persistence.model.CargoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CargoService {
    CargoModel saveCargo(CargoModel cargo);

    CargoModel updateCargo(CargoModel cargo) throws Exception;

    Page<CargoDto> listAllByPage(Pageable pageable, String nombre);

    boolean deleteCargo(Long idCargo) throws Exception;

    List<CargoDto> listCargo();
}
