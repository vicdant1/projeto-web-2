package com.imd.escola.controllers;

import com.imd.escola.models.Aluno;
import com.imd.escola.models.Professor;
import com.imd.escola.models.Turma;
import com.imd.escola.repositories.AlunoRepository;
import com.imd.escola.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private AlunoRepository alunoRepository;
    @GetMapping
    public List<Turma> listarTurmas() {
        return turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Turma buscarTurma(@PathVariable Long id) {
        return turmaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Turma adicionarTurma(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    @PutMapping("/{id}")
    public Turma atualizarTurma(@PathVariable Long id, @RequestBody Turma turmaAtualizada) {
        Turma turmaExistente = turmaRepository.findById(id).orElse(null);
        if (turmaExistente != null) {
            turmaExistente.setNome(turmaAtualizada.getNome());
            // Atualize outras propriedades conforme necessário
            return turmaRepository.save(turmaExistente);
        } else {
            return null; // ou lançar exceção, dependendo dos requisitos
        }
    }

    @DeleteMapping("/{id}")
    public void deletarTurma(@PathVariable Long id) {
        turmaRepository.deleteById(id);
    }

    @GetMapping("/{turmaId}/alunos")
    public List<Aluno> obterAlunosDaTurma(@PathVariable Long turmaId) {
        return alunoRepository.findByTurmasId(turmaId);
    }
}