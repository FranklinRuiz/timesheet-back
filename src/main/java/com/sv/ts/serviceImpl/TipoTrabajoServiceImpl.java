package com.sv.ts.serviceImpl;

import com.sv.ts.config.advice.BusinessException;
import com.sv.ts.dto.TipoTrabajoDto;
import com.sv.ts.enums.Status;
import com.sv.ts.persistence.model.TipoTrabajoModel;
import com.sv.ts.persistence.repository.TipoTrabajoRepository;
import com.sv.ts.service.TipoTrabajoService;
import com.sv.ts.utils.ErrorConstant;
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

public class TipoTrabajoServiceImpl implements TipoTrabajoService {
    private  final TipoTrabajoRepository tipoTrabajoRepository;

    @Override
    @Transactional
    public TipoTrabajoModel saveTipoTrabajo(TipoTrabajoModel tp) {
        tp.setFlgActivo(Status.ACTIVE.isValue());
        return tipoTrabajoRepository.save(tp);
    }

    @Override
    @Transactional
    public TipoTrabajoModel updateTipoTrabajo(TipoTrabajoModel tp) {
        TipoTrabajoModel rpta = null;
        Optional<TipoTrabajoModel> t = Optional.ofNullable(tipoTrabajoRepository.findById(tp.getIdTipoTrabajo()).orElseThrow(() -> new BusinessException(ErrorConstant.ERROR_FIND)));
        if (t.isPresent()) {
            tp.setFlgActivo(t.get().isFlgActivo());
            rpta = tipoTrabajoRepository.save(tp);
        }
        return rpta;
    }

    @Override
    public Page<TipoTrabajoDto> listAllByPage(Pageable pageable, String nombre) {
        Page<TipoTrabajoModel> entities = tipoTrabajoRepository.findByFlgActivoAndNombreTipoTrabajoContaining(pageable, Status.ACTIVE.isValue(), nombre);
        Page<TipoTrabajoDto> dtoPage = entities.map(this::convertToTipoTrabajoDto);
        return dtoPage;
    }

    private TipoTrabajoDto convertToTipoTrabajoDto(final TipoTrabajoModel tipoTrabajoModel) {
        TipoTrabajoDto tpDto = TipoTrabajoDto
                .builder()
                .idTipoTrabajo(tipoTrabajoModel.getIdTipoTrabajo())
                .nombreTipoTrabajo(tipoTrabajoModel.getNombreTipoTrabajo())
                .abreviatura(tipoTrabajoModel.getAbreviatura())
                .build();
        return tpDto;
    }

    @Override
    @Transactional
    public boolean deleteTipoTrabajo(Long idTipoTrabajo) {
        boolean rpta = false;
        Optional<TipoTrabajoModel> t = Optional.ofNullable(tipoTrabajoRepository.findById(idTipoTrabajo).orElseThrow(() -> new BusinessException(ErrorConstant.ERROR_FIND)));
        if (t.isPresent()) {
            t.get().setFlgActivo(Status.INACTIVE.isValue());
            rpta = tipoTrabajoRepository.save(t.get()) != null ? true : false;
        }
        return rpta;
    }

    @Override
    public List<TipoTrabajoDto> listTipoTrabajo() {
        List<TipoTrabajoModel> entities = tipoTrabajoRepository.findByFlgActivo(Status.ACTIVE.isValue());
        List<TipoTrabajoDto> dtoPage = entities.stream().map(this::convertToTipoTrabajoDto).collect(Collectors.toList());
        return dtoPage;
    }
}
