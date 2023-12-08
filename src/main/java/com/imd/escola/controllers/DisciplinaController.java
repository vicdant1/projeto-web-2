package com.imd.escola.controllers;

import com.imd.escola.models.Disciplina;
import com.imd.escola.models.Turma;
import com.imd.escola.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping
    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Disciplina buscarDisciplina(@PathVariable Long id) {
        return disciplinaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Disciplina adicionarTurma(@RequestBody Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @PutMapping("/{id}")
    public Disciplina atualizarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplinaAtualizada) {
        Disciplina disciplinaExistente = disciplinaRepository.findById(id).orElse(null);
        if (disciplinaExistente != null) {
            disciplinaExistente.setNome(disciplinaAtualizada.getNome());
            // Atualize outras propriedades conforme necessário
            return disciplinaRepository.save(disciplinaExistente);
        } else {
            return null; // ou lançar exceção, dependendo dos requisitos
        }
    }

    @DeleteMapping("/{id}")
    public void deletarDisciplina(@PathVariable Long id) {
        disciplinaRepository.deleteById(id);
    }

}