package com.timesheet.serviceImpl;

import com.timesheet.persistence.entity.Cargo;
import com.timesheet.persistence.repository.CargoRepository;
import com.timesheet.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CargoServiceImpl implements CargoService {
    private final CargoRepository cargoRepository;

    @Override
    public Cargo saveCargo(Cargo cargo) {
        cargo.setFlgActivo(true);
        return cargoRepository.save(cargo);
    }

    @Override
    public Cargo updateCargo(Cargo cargo) {
        cargo.setFlgActivo(true);
        return cargoRepository.save(cargo);
    }

    @Override
    public Page<Cargo> listAllByPage(Pageable pageable) {
        return cargoRepository.findByFlgActivo(true, pageable);
    }

    @Override
    public Long deleteCargo(Long idCargo) {
        Long rpta = 0L;
        Cargo c = cargoRepository
                .findById(idCargo)
                .orElseThrow(EntityNotFoundException::new);
        c.setFlgActivo(false);
        rpta = cargoRepository.save(c) != null ? idCargo : 0L;
        return rpta;
    }
}
