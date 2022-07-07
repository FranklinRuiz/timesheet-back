package com.sv.ts.serviceImpl;

import com.sv.ts.persistence.dto.IndicadoresDto;
import com.sv.ts.persistence.dto.IndicadoresHorasPorSedeDto;
import com.sv.ts.persistence.dto.IndicadoresPersonaPorAreaDto;
import com.sv.ts.persistence.repository.IndicadorRepository;
import com.sv.ts.service.IndicadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IndicadorServiceImpl implements IndicadorService {

    private final IndicadorRepository indicadorRepository;


  @Override
    public List<IndicadoresDto> IndDatosPersonas( String FInicio, String FFin) {
    List<IndicadoresDto>  indDto = new ArrayList<>();
    indicadorRepository.SPIndDatosPersonas(FInicio,FFin).forEach(item -> {
      IndicadoresDto i = IndicadoresDto.builder()
              .total(Long.parseLong(item[0].toString()))
              .hombres(Long.parseLong(item[1].toString()))
              .mujeres(Long.parseLong(item[2].toString()))
              .build();
      indDto.add(i);
    });
    return indDto;
  }


  @Override
  public List<IndicadoresPersonaPorAreaDto> IndDatosPersonasPorAreas( String FInicio, String FFin) {
    List<IndicadoresPersonaPorAreaDto>  indDto = new ArrayList<>();
    indicadorRepository.SPIndDatosPersonasPorArea(FInicio,FFin).forEach(item -> {
      IndicadoresPersonaPorAreaDto pxa = IndicadoresPersonaPorAreaDto.builder()
              .area(item[0].toString())
              .cantidad(Long.parseLong(item[1].toString()))
              .build();
      indDto.add(pxa);
    });
    return indDto;
  }


  @Override
  public List<IndicadoresHorasPorSedeDto> IndDatosHorasPorSedes( String FInicio, String FFin) {
    List<IndicadoresHorasPorSedeDto>  indDto = new ArrayList<>();
    indicadorRepository.SPIndDatosHorasPorSede(FInicio,FFin).forEach(item -> {
      IndicadoresHorasPorSedeDto hxs = IndicadoresHorasPorSedeDto.builder()
              .sede(item[0].toString())
              .htrabajadas(item[1].toString())
              .hextra(item[2].toString())
              .htardanza(item[3].toString())
              .build();
      indDto.add(hxs);
    });
    return indDto;
  }


}
 