package com.imd.escola.DTOs;

import com.imd.escola.models.Permissao;

import java.util.List;

public record RecoveryUserDto(
        Long id,
        String email,
        List<Permissao> permissoes
) {
}
