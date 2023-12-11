package com.imd.escola.models;

import com.imd.escola.enums.PermissaoName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="permissao")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PermissaoName nome;
}
