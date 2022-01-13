package com.timesheet.serviceImpl;

import com.timesheet.persistence.entity.Horario;
import com.timesheet.persistence.repository.HorarioRepository;
import com.timesheet.service.HorarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class HorarioServiceImpl implements HorarioService {
    private final HorarioRepository horarioRepository;

    @Override
    public Horario saveHorario(Horario horario){
        horario.setFlgActivo(true);
        return horarioRepository.save(horario);
    }

    @Override
    public Horario updateHorario(Horario horario) {
        horario.setFlgActivo(true);
        return horarioRepository.save(horario);
    }

    @Override
    public Page<Horario> listAllByPage(Pageable pageable) {
        return horarioRepository.findByFlgActivo(true, pageable);
    }

    @Override
    public Long deleteHorario(Long idHorario) {
        Long rpta = 0L;
        Horario c = horarioRepository
                .findById(idHorario)
                .orElseThrow(EntityNotFoundException::new);
        c.setFlgActivo(false);
        rpta = horarioRepository.save(c) != null ? idHorario : 0L;
        return rpta;
    }
}