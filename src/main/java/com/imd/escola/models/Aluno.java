package com.imd.escola.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(name="alunos_turmas",  joinColumns = @JoinColumn(name="aluno_fk"), inverseJoinColumns = @JoinColumn(name="turma_fk"))
    private List<Turma> turmas;

}