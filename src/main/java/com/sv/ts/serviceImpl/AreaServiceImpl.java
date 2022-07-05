package com.sv.ts.serviceImpl;

import com.sv.ts.enums.Status;
import com.sv.ts.persistence.dto.AreaDto;
import com.sv.ts.persistence.model.AreaModel;
import com.sv.ts.persistence.repository.AreaRepository;
import com.sv.ts.service.AreaService;
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
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;

    @Override
    @Transactional
    public AreaModel saveArea(AreaModel area){
        area.setFlgActivo(Status.ACTIVE.isValue());
        return  areaRepository.save(area);
    }

    @Override
    @Transactional
    public AreaModel updateArea(AreaModel area) throws Exception {
        AreaModel rpta = null;
        Optional<AreaModel> t = Optional.ofNullable(areaRepository.findById(area.getIdArea()).orElseThrow(() -> new Exception("Area no encontrado para actualizar")));
        if (t.isPresent()) {
            area.setFlgActivo(t.get().isFlgActivo());
            rpta = areaRepository.save(area);
        }
        return rpta;
    }

    @Override
    public Page<AreaDto> listAllByPage(Pageable pageable, Long idArea) {
        Page<AreaModel> entities = areaRepository.findByFlgActivoAndIdAreaContaining(pageable, Status.ACTIVE.isValue(), idArea);
        Page<AreaDto> dtoPage = entities.map(this::convertToAreaDto);
        return dtoPage;
    }

    private AreaDto convertToAreaDto(final AreaModel areaModel) {
        AreaDto areaDto = AreaDto
                .builder()
                .idArea(areaModel.getIdArea())
                .codigoArea(areaModel.getCodigoArea())
                .nombreArea(areaModel.getNombreArea())
                .build();
        return areaDto;
    }

    @Override
    @Transactional
    public boolean deleteArea(Long idArea) throws Exception {
        boolean rpta = false;
        Optional<AreaModel> t = Optional.ofNullable(areaRepository.findById(idArea).orElseThrow(() -> new Exception("Area no encontrado para eliminar")));
        if (t.isPresent()) {
            t.get().setFlgActivo(Status.INACTIVE.isValue());
            rpta = areaRepository.save(t.get()) != null ? true : false;
        }
        return rpta;
    }

    @Override
    public List<AreaDto> listArea() {
        List<AreaModel> entities = areaRepository.findByFlgActivo(Status.ACTIVE.isValue());
        List<AreaDto> dtoPage = entities.stream().map(this::convertToAreaDto).collect(Collectors.toList());
        return dtoPage;
    }
}
