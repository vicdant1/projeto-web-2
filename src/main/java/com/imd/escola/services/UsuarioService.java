package com.imd.escola.services;

import com.imd.escola.DTOs.CriarUsuarioDto;
import com.imd.escola.DTOs.LoginDto;
import com.imd.escola.DTOs.RecoveryJwtTokenDto;
import com.imd.escola.configurations.SecurityConfig;
import com.imd.escola.models.Permissao;
import com.imd.escola.models.Usuario;
import com.imd.escola.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SecurityConfig securityConfig;

    public RecoveryJwtTokenDto authenticateUser(LoginDto loginDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.login(), loginDto.senha());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        Usuario userDetails = (Usuario) authentication.getPrincipal();

        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }

    public void createUser(CriarUsuarioDto criarUsuarioDto) {

        Usuario novoUsuario = Usuario.builder()
                .login(criarUsuarioDto.login())
                .senha(securityConfig.passwordEncoder().encode(criarUsuarioDto.senha()))
                .permissoes(List.of(Permissao.builder().nome(criarUsuarioDto.permissao()).build()))
                .build();

        usuarioRepository.save(novoUsuario);
    }
}
