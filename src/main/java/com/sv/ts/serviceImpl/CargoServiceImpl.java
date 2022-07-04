package com.sv.ts.serviceImpl;

import com.sv.ts.persistence.dto.CargoDto;
import com.sv.ts.enums.Status;
import com.sv.ts.persistence.model.CargoModel;
import com.sv.ts.persistence.repository.CargoRepository;
import com.sv.ts.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;

    @Override
    @Transactional
    public CargoModel saveCargo(CargoModel cargo) {
        cargo.setFlgActivo(Status.ACTIVE.isValue());
        return cargoRepository.save(cargo);
    }

    @Override
    @Transactional
    public CargoModel updateCargo(CargoModel cargo) throws Exception {
        CargoModel rpta = null;
        Optional<CargoModel> t = Optional.ofNullable(cargoRepository.findById(cargo.getIdCargo()).orElseThrow(() -> new Exception("Cargo no encontrado para actualizar")));
        if (t.isPresent()) {
            cargo.setFlgActivo(t.get().isFlgActivo());
            rpta = cargoRepository.save(cargo);
        }
        return rpta;
    }

    @Override
    public Page<CargoDto> listAllByPage(Pageable pageable, String nombre) {
        Page<CargoModel> entities = cargoRepository.findByFlgActivoAndNombreCargoContaining(pageable, Status.ACTIVE.isValue(), nombre);
        Page<CargoDto> dtoPage = entities.map(this::convertToCargoDto);
        return dtoPage;
    }

    private CargoDto convertToCargoDto(final CargoModel cargoModel) {
        CargoDto cargoDto = CargoDto
                .builder()
                .idCargo(cargoModel.getIdCargo())
                .codigoCargo(cargoModel.getCodigoCargo())
                .nombreCargo(cargoModel.getNombreCargo())
                .build();
        return cargoDto;
    }

    @Override
    @Transactional
    public boolean deleteCargo(Long idCargo) throws Exception {
        boolean rpta = false;
        Optional<CargoModel> t = Optional.ofNullable(cargoRepository.findById(idCargo).orElseThrow(() -> new Exception("Cargo no encontrado para eliminar")));
        if (t.isPresent()) {
            t.get().setFlgActivo(Status.INACTIVE.isValue());
            rpta = cargoRepository.save(t.get()) != null ? true : false;
        }
        return rpta;
    }

    @Override
    public List<CargoDto> listCargo() {
        List<CargoModel> entities = cargoRepository.findByFlgActivo(Status.ACTIVE.isValue());
        List<CargoDto> dtoPage = entities.stream().map(this::convertToCargoDto).collect(Collectors.toList());
        return dtoPage;
    }
}
