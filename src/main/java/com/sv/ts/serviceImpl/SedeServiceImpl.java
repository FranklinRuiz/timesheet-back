package com.sv.ts.serviceImpl;

import com.sv.ts.config.advice.BusinessException;
import com.sv.ts.dto.SedeDto;
import com.sv.ts.enums.Status;
import com.sv.ts.persistence.model.SedeModel;
import com.sv.ts.persistence.repository.SedeRepository;
import com.sv.ts.service.SedeService;
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
public class SedeServiceImpl implements SedeService {
    private  final SedeRepository sedeRepository;

    @Override
    @Transactional
    public SedeModel saveSede(SedeModel sede) {
        sede.setFlgActivo(Status.ACTIVE.isValue());
        return sedeRepository.save(sede);
    }

    @Override
    @Transactional
    public SedeModel updateSede(SedeModel sede) {
        SedeModel rpta = null;
        Optional<SedeModel> t = Optional.ofNullable(sedeRepository.findById(sede.getIdSede()).orElseThrow(() -> new BusinessException(ErrorConstant.ERROR_FIND)));
        if (t.isPresent()) {
            sede.setFlgActivo(t.get().isFlgActivo());
            rpta = sedeRepository.save(sede);
        }
        return rpta;
    }

    @Override
    public Page<SedeDto> listAllByPage(Pageable pageable, String nombre) {
        Page<SedeModel> entities = sedeRepository.findByFlgActivoAndNombreSedeContaining(pageable, Status.ACTIVE.isValue(), nombre);
        Page<SedeDto> dtoPage = entities.map(this::convertToSedeDto);
        return dtoPage;
    }

    private SedeDto convertToSedeDto(final SedeModel sedeModel) {
        SedeDto sedeDto = SedeDto
                .builder()
                .idSede(sedeModel.getIdSede())
                .nombreSede(sedeModel.getNombreSede())
                .descripcion(sedeModel.getDescripcion())
                .direccion(sedeModel.getDireccion())
                .beacon(sedeModel.getBeacon())
                .build();
        return sedeDto;
    }

    @Override
    @Transactional
    public boolean deleteSede(Long idSede) {
        boolean rpta = false;
        Optional<SedeModel> t = Optional.ofNullable(sedeRepository.findById(idSede).orElseThrow(() -> new BusinessException(ErrorConstant.ERROR_FIND)));
        if (t.isPresent()) {
            t.get().setFlgActivo(Status.INACTIVE.isValue());
            rpta = sedeRepository.save(t.get()) != null ? true : false;
        }
        return rpta;
    }

    @Override
    public List<SedeDto> listSede() {
        List<SedeModel> entities = sedeRepository.findByFlgActivo(Status.ACTIVE.isValue());
        List<SedeDto> dtoPage = entities.stream().map(this::convertToSedeDto).collect(Collectors.toList());
        return dtoPage;
    }
}
