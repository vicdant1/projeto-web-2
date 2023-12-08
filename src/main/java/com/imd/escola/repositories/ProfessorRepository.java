package com.imd.escola.repositories;

import com.imd.escola.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    // Adicione métodos específicos do repositório, se necessário
}