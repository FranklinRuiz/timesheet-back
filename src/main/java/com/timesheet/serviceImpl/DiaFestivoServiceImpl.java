package com.timesheet.serviceImpl;

import com.timesheet.persistence.entity.DiaFestivo;
import com.timesheet.persistence.repository.DiaFestivoRepository;
import com.timesheet.service.DiaFestivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class DiaFestivoServiceImpl implements DiaFestivoService {
    private final DiaFestivoRepository diaFestivoRepository;

    @Override
    public DiaFestivo saveDiaFestivo(DiaFestivo diaFestivo) {
        diaFestivo.setFlgActivo(true);
        return diaFestivoRepository.save(diaFestivo);
    }

    @Override
    public DiaFestivo updateDiaFestivo(DiaFestivo diaFestivo) {
        diaFestivo.setFlgActivo(true);
        return diaFestivoRepository.save(diaFestivo);
    }

    @Override
    public Page<DiaFestivo> listAllByPage(Pageable pageable) {
        return diaFestivoRepository.findByFlgActivo(true, pageable);
    }

    @Override
    public Long deleteDiaFestivo(Long idDiaFestivo) {
        Long rpta = 0L;
        DiaFestivo c = diaFestivoRepository
                .findById(idDiaFestivo)
                .orElseThrow(EntityNotFoundException::new);
        c.setFlgActivo(false);
        rpta = diaFestivoRepository.save(c) != null ? idDiaFestivo : 0L;
        return rpta;
    }
}
