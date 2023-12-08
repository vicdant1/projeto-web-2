ALTER TABLE Turma
    ADD professor_id BIGINT,
    ADD FOREIGN KEY (professor_id) REFERENCES Professor(id)
;

CREATE TABLE Turma_Disciplina (
                                  turma_id BIGINT,
                                  disciplina_id BIGINT,
                                  PRIMARY KEY (turma_id, disciplina_id),
                                  FOREIGN KEY (turma_id) REFERENCES Turma(id),
                                  FOREIGN KEY (disciplina_id) REFERENCES Disciplina(id)
);
