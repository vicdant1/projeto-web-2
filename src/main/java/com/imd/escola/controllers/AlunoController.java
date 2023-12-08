package com.imd.escola.controllers;

import com.imd.escola.models.Aluno;
import com.imd.escola.models.Turma;
import com.imd.escola.repositories.AlunoRepository;
import com.imd.escola.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Aluno buscarAluno(@PathVariable Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Aluno adicionarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        Aluno alunoExistente = alunoRepository.findById(id).orElse(null);
        if (alunoExistente != null) {
            alunoExistente.setNome(alunoAtualizado.getNome());
            // Atualize outras propriedades conforme necessário
            return alunoRepository.save(alunoExistente);
        } else {
            return null; // ou lançar exceção, dependendo dos requisitos
        }
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        alunoRepository.deleteById(id);
    }

    @GetMapping("/{alunoId}/turmas")
    public List<Turma> obterTurmasDoAluno(@PathVariable Long alunoId) {
        return turmaRepository.findByAlunosId(alunoId);
    }

}