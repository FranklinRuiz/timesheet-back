package com.timesheet.controller;

import com.timesheet.dto.UserDto;


import com.timesheet.persistence.entity.Usuario;
import com.timesheet.serviceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Usuario> signup(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

    @GetMapping("/user")
    public ResponseEntity<Usuario> getMyUserInfo() {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<Usuario> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(username).get());
    }
}
