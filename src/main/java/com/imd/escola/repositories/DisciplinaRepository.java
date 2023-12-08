package com.imd.escola.repositories;

import com.imd.escola.models.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    // Adicione métodos específicos do repositório, se necessário
}
