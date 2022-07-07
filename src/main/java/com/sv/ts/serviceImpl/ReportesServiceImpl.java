package com.sv.ts.serviceImpl;

import com.sv.ts.persistence.dto.*;
import com.sv.ts.persistence.repository.ReportesRepository;
import com.sv.ts.service.ReportesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ReportesServiceImpl implements ReportesService {

    private final ReportesRepository reportesRepository;

    @Override
    public List<ReporteGeneralDto> RepGeneral(Long IdSede, Long IdTurno){
        List<ReporteGeneralDto> rpteG = new ArrayList<>();
        reportesRepository.SPRepGeneral(IdSede,IdTurno).forEach(item -> {
            ReporteGeneralDto rp = ReporteGeneralDto.builder()
                    .personal(item[0].toString())
                    .area(item[1].toString())
                    .cargo(item[2].toString())
                    .sede(item[3].toString())
                    .hentrada(item[4].toString())
                    .hsalida(item[5].toString())
                    .turno(item[6].toString())
                    .horatrabajada(item[7].toString())
                    .horaextra(item[8].toString())
                    .horatardanza(item[9].toString())
                    .correo(item[10].toString())
                    .telefono(item[11].toString())
                    .direccion(item[12].toString())
                    .genero(item[13].toString())
                    .fecnacimiento(item[14].toString())
                    .tipoDocumento(item[15].toString())
                    .build();
            rpteG.add(rp);
        });
        return rpteG;
    }


    @Override
    public List<ReporteTurnoDto> RepTurno(Long IdTurno){
        List<ReporteTurnoDto> rpteT = new ArrayList<>();
        reportesRepository.SPRepTurno(IdTurno).forEach(item -> {
            ReporteTurnoDto rp = ReporteTurnoDto.builder()
                    .personal(item[0].toString())
                    .turno(item[1].toString())
                    .hinicio(item[2].toString())
                    .hfin(item[3].toString())
                    .build();
            rpteT.add(rp);
        });
        return rpteT;
    }


    @Override
    public List<ReporteHorasTrabajolDto> RepHorasTrabajo(Long IdSede, String TipoHora){
        List<ReporteHorasTrabajolDto> rpteHt = new ArrayList<>();
        reportesRepository.SPRepHorasDeTrabajo(IdSede,TipoHora).forEach(item -> {
            ReporteHorasTrabajolDto rp = ReporteHorasTrabajolDto.builder()
                    .personal(item[0].toString())
                    .sede(item[1].toString())
                    .horas(item[2].toString())
                    .build();
            rpteHt.add(rp);
        });
        return rpteHt;
    }

    @Override
    public List<ReporteAsistenciaDto> RepAsistencias(){
        List<ReporteAsistenciaDto> rpteAsis = new ArrayList<>();
        reportesRepository.SPRepAsistencia().forEach(item -> {
            ReporteAsistenciaDto rp = ReporteAsistenciaDto.builder()
                    .empleado(item[0].toString())
                    .hentrada(item[1].toString())
                    .hsalida(item[2].toString())
                    .build();
            rpteAsis.add(rp);
        });
        return rpteAsis;
    }


    @Override
    public List<ReporteInasistenciaDto> RepInasistencias(){
        List<ReporteInasistenciaDto> rpteIna = new ArrayList<>();
        reportesRepository.SPRepInasistencia().forEach(item -> {
            ReporteInasistenciaDto rp = ReporteInasistenciaDto.builder()
                    .empleado(item[0].toString())
                    .finasistencia(item[1].toString())
                    .build();
            rpteIna.add(rp);
        });
        return rpteIna;
    }


}
