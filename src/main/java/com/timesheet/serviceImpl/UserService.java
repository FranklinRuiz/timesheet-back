package com.timesheet.serviceImpl;

import com.timesheet.dto.UserDto;

import com.timesheet.persistence.entity.Authority;
import com.timesheet.persistence.entity.Usuario;
import com.timesheet.persistence.repository.IUsuarioRepository;
import com.timesheet.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUsuarioRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario signup(UserDto userDto) {
//        if (userRepository.findOneWithAuthoritiesByUsuario(userDto.getUsuario()).orElse(null) != null) {
//            throw new DuplicateMemberException("Ya eres un usuario registrado.");
//        }

        //Ventajas del patrón constructor
        Authority authority = Authority.builder()
                .nombreRol("ROLE_USER")
                .build();

        Usuario user = Usuario.builder()
                .usuario(userDto.getUsuario())
                .password(passwordEncoder.encode(userDto.getPassword()))
                //.nickname(userDto.getNickname())
                .authorities(Collections.singleton(authority))
                .estado(true)
                .build();

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> getUserWithAuthorities(String username) {
        return userRepository.findOneWithAuthoritiesByUsuario(username);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsuario);
    }
}
