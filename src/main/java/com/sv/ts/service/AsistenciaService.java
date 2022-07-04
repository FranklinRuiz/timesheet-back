package com.sv.ts.service;

import com.sv.ts.persistence.model.AsistenciaModel;

import java.util.List;

public interface AsistenciaService {
    boolean save(List<AsistenciaModel> asistenciaModels);
}
