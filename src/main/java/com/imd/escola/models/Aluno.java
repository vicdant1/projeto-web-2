package com.imd.escola.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    //@ManyToMany(mappedBy = "alunos", cascade = CascadeType.ALL)
    @ManyToMany
    @JoinTable(name="alunos_turmas",  joinColumns = @JoinColumn(name="aluno_fk"), inverseJoinColumns = @JoinColumn(name="turma_fk"))
    private List<Turma> turmas;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}