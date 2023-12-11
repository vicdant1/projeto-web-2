package com.imd.escola.DTOs;

import com.imd.escola.enums.PermissaoName;

public record CriarUsuarioDto(
        String login,
        String senha,
        PermissaoName permissao
) {
}
