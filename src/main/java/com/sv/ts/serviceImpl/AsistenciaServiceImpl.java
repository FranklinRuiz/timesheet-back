package com.sv.ts.serviceImpl;

import com.sv.ts.persistence.model.AsistenciaModel;
import com.sv.ts.persistence.repository.AsistenciaRepository;
import com.sv.ts.service.AsistenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AsistenciaServiceImpl implements AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;

    @Override
    public boolean save(List<AsistenciaModel> asistenciaModels){
        List<AsistenciaModel> Asis = new ArrayList<>();
        asistenciaModels.forEach(item ->{
            item.setFlgActivo(true);
            Asis.add(item);
        });
        return asistenciaRepository.saveAll(Asis) != null ? true : false;
    }
}
