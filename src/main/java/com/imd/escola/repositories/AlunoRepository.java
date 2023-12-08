package com.imd.escola.repositories;

import com.imd.escola.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Adicione métodos específicos do repositório, se necessário
    List<Aluno> findByTurmasId(Long turmaId);
}