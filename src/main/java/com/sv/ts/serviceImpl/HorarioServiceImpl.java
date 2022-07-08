package com.sv.ts.serviceImpl;

import com.sv.ts.config.advice.BusinessException;
import com.sv.ts.persistence.dto.HorarioDto;
import com.sv.ts.enums.Status;
import com.sv.ts.persistence.model.CargoModel;
import com.sv.ts.persistence.model.HorarioModel;
import com.sv.ts.persistence.repository.HorarioRepository;
import com.sv.ts.service.HorarioService;
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
public class HorarioServiceImpl implements HorarioService {

    private final HorarioRepository horarioRepository;

    @Override
    @Transactional
    public HorarioModel saveHorario(HorarioModel horario) {
        Optional<HorarioModel> pm = Optional.ofNullable(horarioRepository.findByNombreAndFlgActivo(horario.getNombre(), true));
        if (pm.isPresent()) {
            throw new BusinessException(ErrorConstant.ERROR_HORARIO_EXISTES);
        }
        horario.setFlgActivo(Status.ACTIVE.isValue());
        return horarioRepository.save(horario);
    }

    @Override
    @Transactional
    public HorarioModel updateHorario(HorarioModel horario) {
        HorarioModel rpta = null;
        Optional<HorarioModel> t = Optional.ofNullable(horarioRepository.findById(horario.getIdHorario()).orElseThrow(() -> new BusinessException(ErrorConstant.ERROR_FIND)));
        if (t.isPresent()) {
            horario.setFlgActivo(t.get().isFlgActivo());
            rpta = horarioRepository.save(horario);
        }
        return rpta;
    }

    @Override
    public Page<HorarioDto> listAllByPage(Pageable pageable, String nombre) {
        Page<HorarioModel> entities = horarioRepository.findByFlgActivoAndNombreContaining(pageable, Status.ACTIVE.isValue(), nombre);
        Page<HorarioDto> dtoPage = entities.map(this::convertToHorarioDto);
        return dtoPage;
    }

    private HorarioDto convertToHorarioDto(final HorarioModel horarioModel) {
        HorarioDto horarioDto = HorarioDto
                .builder()
                .idHorario(horarioModel.getIdHorario())
                .nombre(horarioModel.getNombre())
                .horaInicio(horarioModel.getHoraInicio())
                .horaFin(horarioModel.getHoraFin())
                .build();
        return horarioDto;
    }

    @Override
    @Transactional
    public boolean deleteHorario(Long idHorario) {
        boolean rpta = false;
        Optional<HorarioModel> t = Optional.ofNullable(horarioRepository.findById(idHorario).orElseThrow(() -> new BusinessException(ErrorConstant.ERROR_FIND)));
        if (t.isPresent()) {
            t.get().setFlgActivo(Status.INACTIVE.isValue());
            rpta = horarioRepository.save(t.get()) != null ? true : false;
        }
        return rpta;
    }

    @Override
    public List<HorarioDto> listHorario() {
        List<HorarioModel> entities = horarioRepository.findByFlgActivo(Status.ACTIVE.isValue());
        List<HorarioDto> dtoPage = entities.stream().map(this::convertToHorarioDto).collect(Collectors.toList());
        return dtoPage;
    }
}
