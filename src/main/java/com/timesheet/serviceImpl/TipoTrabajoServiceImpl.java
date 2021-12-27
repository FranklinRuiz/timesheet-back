package com.timesheet.serviceImpl;

import com.timesheet.persistence.entity.Cargo;
import com.timesheet.persistence.entity.TipoTrabajo;
import com.timesheet.persistence.repository.TipoTrabajoRepository;
import com.timesheet.service.TipoTrabajoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class TipoTrabajoServiceImpl implements TipoTrabajoService {

    private final TipoTrabajoRepository tipoTrabajoRepository;

    @Override
    public TipoTrabajo save(TipoTrabajo tipoTrabajo) {
        tipoTrabajo.setFlgActivo(true);
        return tipoTrabajoRepository.save(tipoTrabajo);
    }

    @Override
    public TipoTrabajo update(TipoTrabajo tipoTrabajo) {
        tipoTrabajo.setFlgActivo(true);
        return tipoTrabajoRepository.save(tipoTrabajo);
    }

    @Override
    public Page<TipoTrabajo> list(Pageable pageable) {
        return tipoTrabajoRepository.findByFlgActivo(true, pageable);
    }

    @Override
    public Long delete(Long idTipoTrabajo) {
        Long rpta = 0L;
        TipoTrabajo c = tipoTrabajoRepository
                .findById(idTipoTrabajo)
                .orElseThrow(EntityNotFoundException::new);
        c.setFlgActivo(false);
        rpta = tipoTrabajoRepository.save(c) != null ? idTipoTrabajo : 0L;
        return rpta;
    }
}
