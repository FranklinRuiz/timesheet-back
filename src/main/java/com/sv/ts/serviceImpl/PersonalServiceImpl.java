package com.sv.ts.serviceImpl;

import com.sv.ts.config.advice.BusinessException;
import com.sv.ts.persistence.dto.PersonalDto;
import com.sv.ts.persistence.dto.TempDto;
import com.sv.ts.enums.Status;
import com.sv.ts.enums.TipoDocumento;
import com.sv.ts.enums.TipoGenero;
import com.sv.ts.persistence.model.EmpleadoModel;
import com.sv.ts.persistence.model.PersonaModel;
import com.sv.ts.persistence.repository.EmpleadoRepository;
import com.sv.ts.persistence.repository.PersonaRepository;
import com.sv.ts.service.PersonalService;
import com.sv.ts.utils.ErrorConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonalServiceImpl implements PersonalService {

    private final PersonaRepository personaRepository;
    private final EmpleadoRepository empleadoRepository;

    @Override
    @Transactional
    public PersonalDto savePersonal(PersonalDto personal) {

        Optional<PersonaModel> pm = Optional.ofNullable(personaRepository.findByNumeroDocumento(personal.getNumeroDocumento()));
        if (pm.isPresent()) {
            throw new BusinessException(ErrorConstant.ERROR_EMPLOYEE_EXISTES);
        }

        PersonaModel persona = new PersonaModel();
        persona.setTipoDocumento(personal.getTipoDocumento());
        persona.setNumeroDocumento(personal.getNumeroDocumento());
        persona.setNombres(personal.getNombres());
        persona.setApellidoPaterno(personal.getApellidoPaterno());
        persona.setApellidoMaterno(personal.getApellidoMaterno());
        persona.setFechaNacimiento(personal.getFechaNacimiento());
        persona.setSexo(personal.getSexo());
        persona.setNombreCompleto(personal.getNombres() + " " + personal.getApellidoPaterno() + " " + personal.getApellidoMaterno());
        persona.setFlgActivo(Status.ACTIVE.isValue());
        PersonaModel p = personaRepository.save(persona);

        EmpleadoModel empleado = new EmpleadoModel();
        empleado.setIdPersona(p.getIdPersona());
        empleado.setIdCargo(personal.getIdCargo());
        empleado.setIdArea(personal.getIdArea());
        empleado.setIdHorario(personal.getIdHorario());
        empleado.setCodigoEmpleado(personal.getCodigoEmpleado());
        empleado.setTelefono(personal.getTelefono());
        empleado.setCorreo(personal.getCorreo());
        empleado.setDireccion(personal.getDireccion());
        empleado.setFoto(personal.getFoto());
        empleado.setFlgActivo(Status.ACTIVE.isValue());
        EmpleadoModel e = empleadoRepository.save(empleado);

        PersonalDto personalDto = PersonalDto.builder()
                .idEmpleado(e.getIdEmpleado())
                .codigoEmpleado(e.getCodigoEmpleado())
                .tipoDocumento(p.getTipoDocumento())
                .numeroDocumento(p.getNumeroDocumento())
                .nombres(p.getNombres())
                .apellidoPaterno(p.getApellidoPaterno())
                .apellidoMaterno(p.getApellidoMaterno())
                .fechaNacimiento(p.getFechaNacimiento())
                .sexo(p.getSexo())
                .idCargo(e.getIdCargo())
                .idHorario(e.getIdHorario())
                .telefono(e.getTelefono())
                .correo(e.getCorreo())
                .direccion(e.getDireccion())
                .foto(e.getFoto())
                .build();

        return personalDto;
    }

    @Override
    @Transactional
    public PersonalDto updatePersonal(PersonalDto personal) {
        EmpleadoModel empleado = Optional.ofNullable(empleadoRepository.findById(personal.getIdEmpleado()).orElseThrow(() -> new BusinessException(ErrorConstant.ERROR_FIND))).get();
        PersonaModel persona = Optional.ofNullable(personaRepository.findById(empleado.getIdPersona()).orElseThrow(() -> new BusinessException(ErrorConstant.ERROR_FIND))).get();
        empleado.setIdCargo(personal.getIdCargo());
        empleado.setIdArea(personal.getIdArea());
        empleado.setIdHorario(personal.getIdHorario());
        empleado.setCodigoEmpleado(personal.getCodigoEmpleado());
        empleado.setTelefono(personal.getTelefono());
        empleado.setCorreo(personal.getCorreo());
        empleado.setDireccion(personal.getDireccion());
        empleado.setFoto(personal.getFoto());
        EmpleadoModel e = empleadoRepository.save(empleado);

        persona.setTipoDocumento(personal.getTipoDocumento());
        persona.setNumeroDocumento(personal.getNumeroDocumento());
        persona.setNombres(personal.getNombres());
        persona.setApellidoPaterno(personal.getApellidoPaterno());
        persona.setApellidoMaterno(personal.getApellidoMaterno());
        persona.setFechaNacimiento(personal.getFechaNacimiento());
        persona.setSexo(personal.getSexo());
        persona.setNombreCompleto(personal.getNombres() + " " + personal.getApellidoPaterno() + " " + personal.getApellidoMaterno());
        PersonaModel p = personaRepository.save(persona);

        PersonalDto personalDto = PersonalDto.builder()
                .idEmpleado(e.getIdEmpleado())
                .codigoEmpleado(e.getCodigoEmpleado())
                .tipoDocumento(p.getTipoDocumento())
                .numeroDocumento(p.getNumeroDocumento())
                .nombres(p.getNombres())
                .apellidoPaterno(p.getApellidoPaterno())
                .apellidoMaterno(p.getApellidoMaterno())
                .fechaNacimiento(p.getFechaNacimiento())
                .sexo(p.getSexo())
                .idCargo(e.getIdCargo())
                .idHorario(e.getIdHorario())
                .telefono(e.getTelefono())
                .correo(e.getCorreo())
                .direccion(e.getDireccion())
                .foto(e.getFoto())
                .idArea(e.getIdArea())
                .build();

        return personalDto;
    }

    @Override
    public Page<PersonalDto> listAllByPage(Pageable pageable, String nombre) {
        Page<Object[]> entities = empleadoRepository.findAllByPage(nombre, Status.ACTIVE.isValue(), pageable);
        Page<PersonalDto> dtoPage = entities.map(this::convertToPersonalDto);
        return dtoPage;
    }

    private PersonalDto convertToPersonalDto(final Object[] model) {
        EmpleadoModel e = (EmpleadoModel) model[0];
        PersonalDto personalDto = PersonalDto
                .builder()
                .idEmpleado(e.getIdEmpleado())
                .codigoEmpleado(e.getCodigoEmpleado())
                .tipoDocumento(Integer.parseInt(model[1].toString()))
                .numeroDocumento(model[2].toString())
                .nombres(model[3].toString())
                .apellidoPaterno(model[4].toString())
                .apellidoMaterno(model[5].toString())
                .fechaNacimiento(LocalDate.parse(model[6].toString()))
                .sexo(model[7].toString())
                .nombreCompleto(model[8].toString())
                .idCargo(e.getIdCargo())
                .cargo(model[9].toString())
                .idHorario(e.getIdHorario())
                .horario(model[10].toString())
                .telefono(e.getTelefono())
                .correo(e.getCorreo())
                .direccion(e.getDireccion())
                .foto(e.getFoto())
                .idArea(e.getIdArea())
                .build();
        return personalDto;
    }

    @Override
    @Transactional
    public boolean deletePersonal(Long idPersonal) {
        boolean rpta = false;
        Optional<EmpleadoModel> t = Optional.ofNullable(empleadoRepository.findById(idPersonal).orElseThrow(() -> new BusinessException(ErrorConstant.ERROR_FIND)));
        if (t.isPresent()) {
            t.get().setFlgActivo(Status.INACTIVE.isValue());
            rpta = empleadoRepository.save(t.get()) != null ? true : false;
        }
        return rpta;
    }

    @Override
    public List<TempDto> listTipoDocumento() {
        List<TempDto> list = new ArrayList<>();
        TipoDocumento.list().forEach((item) -> {
            TempDto dto = new TempDto();
            dto.setId(item.getId());
            dto.setNombre(item.getCode());
            list.add(dto);
        });
        return list;
    }

    @Override
    public List<TempDto> listTipoGenero() {
        List<TempDto> list = new ArrayList<>();
        TipoGenero.list().forEach((item) -> {
            TempDto dto = new TempDto();
            dto.setId(item.getId());
            dto.setNombre(item.getNombre());
            list.add(dto);
        });
        return list;
    }
}
