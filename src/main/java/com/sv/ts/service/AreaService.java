package com.sv.ts.service;

import com.sv.ts.persistence.dto.AreaDto;
import com.sv.ts.persistence.model.AreaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AreaService {
    AreaModel saveArea(AreaModel area);
    AreaModel updateArea(AreaModel area) throws Exception;
    Page<AreaDto> listAllByPage(Pageable pageable, Long idArea);
    boolean deleteArea(Long idArea) throws Exception;
    List<AreaDto> listArea();
}
