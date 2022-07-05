package com.sv.ts.serviceImpl;

import com.sv.ts.dto.AsistenciaDto;
import com.sv.ts.dto.CargoDto;
import com.sv.ts.dto.PersonalDto;
import com.sv.ts.enums.Status;
import com.sv.ts.persistence.model.AsistenciaModel;
import com.sv.ts.persistence.model.CargoModel;
import com.sv.ts.persistence.model.EmpleadoModel;
import com.sv.ts.persistence.repository.AsistenciaRepository;
import com.sv.ts.persistence.repository.CargoRepository;
import com.sv.ts.service.AsistenciaService;
import com.sv.ts.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AsistenciaServiceImpl implements AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;

    @Override
    @Transactional
    public AsistenciaDto saveAsistencia(AsistenciaDto asistencia) {
        AsistenciaModel asistenciaModel = new AsistenciaModel();
        asistenciaModel.setIdEmpleado(asistencia.getIdEmpleado());
        asistenciaModel.setIdTipoTrabajo(asistencia.getIdTipoTrabajo());
        asistenciaModel.setHoraEntrada(asistencia.getHoraEntrada());
        asistenciaModel.setHoraSalida(asistencia.getHoraSalida());
        asistenciaModel.setFlgActivo(Status.ACTIVE.isValue());
        asistenciaRepository.save(asistenciaModel);
        return asistencia;
    }

    @Override
    public AsistenciaDto getAsistencia(Long idEmpleado) {
        return null;
    }

    @Override
    public Page<AsistenciaDto> listAllByPage(Pageable pageable) {
        Page<Object[]> entities = asistenciaRepository.findAllByPage(Status.ACTIVE.isValue(), pageable);
        Page<AsistenciaDto> dtoPage = entities.map(this::convertToAsistenciaDto);
        return dtoPage;
    }

    private AsistenciaDto convertToAsistenciaDto(final Object[] model) {
        AsistenciaModel a = (AsistenciaModel) model[0];
        AsistenciaDto asistenciaDto = AsistenciaDto
                .builder()
                .idAsistencia(a.getIdAsistencia())
                .idEmpleado(a.getIdEmpleado())
                .empleado(model[2].toString())
                .idTipoTrabajo(a.getIdTipoTrabajo())
                .tipoTrabajo(model[1].toString())
                .horaEntrada(a.getHoraEntrada())
                .horaSalida(a.getHoraSalida())
                .fecha(a.getDateReg())
                .build();
        return asistenciaDto;
    }
}
