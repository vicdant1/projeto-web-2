package com.imd.escola.controllers;

import com.imd.escola.DTOs.CriarUsuarioDto;
import com.imd.escola.DTOs.LoginDto;
import com.imd.escola.DTOs.RecoveryJwtTokenDto;
import com.imd.escola.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDto> authenticateUser(@RequestBody LoginDto loginDto) {
        RecoveryJwtTokenDto token = usuarioService.authenticateUser(loginDto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CriarUsuarioDto createUserDto) {
        usuarioService.createUser(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
