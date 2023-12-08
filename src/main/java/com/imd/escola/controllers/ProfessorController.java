package com.imd.escola.controllers;

import com.imd.escola.models.Professor;
import com.imd.escola.models.Turma;
import com.imd.escola.repositories.ProfessorRepository;
import com.imd.escola.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping
    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Professor buscarProfessor(@PathVariable Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Professor adicionarProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/{id}")
    public Professor atualizarProfessor(@PathVariable Long id, @RequestBody Professor professorAtualizado) {
        Professor professorExistente = professorRepository.findById(id).orElse(null);
        if (professorExistente != null) {
            professorExistente.setNome(professorAtualizado.getNome());
            // Atualize outras propriedades conforme necessário
            return professorRepository.save(professorExistente);
        } else {
            return null; // ou lançar exceção, dependendo dos requisitos
        }
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Long id) {
        professorRepository.deleteById(id);
    }

    @GetMapping("/{professorId}/turmas")
    public List<Turma> obterTurmasDoProfessor(@PathVariable Long professorId) {
        return turmaRepository.findByProfessorId(professorId);
    }
}