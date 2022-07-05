package com.sv.ts.persistence.repository;

import com.sv.ts.persistence.model.AreaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaRepository extends JpaRepository<AreaModel, Long> {

    Page<AreaModel> findByFlgActivoAndIdAreaContaining(Pageable pageable, boolean flgActivo, Long idArea);
    List<AreaModel> findByFlgActivo(boolean flgActivo);

}
