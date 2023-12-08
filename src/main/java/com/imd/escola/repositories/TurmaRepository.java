package com.imd.escola.repositories;

import com.imd.escola.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    // Adicione métodos específicos do repositório, se necessário
    List<Turma> findByProfessorId(Long professorId);
    List<Turma> findByAlunosId(Long alunoId);
}