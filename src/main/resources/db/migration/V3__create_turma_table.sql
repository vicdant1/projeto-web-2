ALTER TABLE turma
    ADD professor_id BIGINT,
    ADD FOREIGN KEY (professor_id) REFERENCES professor(id)
;

CREATE TABLE turma_disciplina (
                                  turma_id BIGINT,
                                  disciplina_id BIGINT,
                                  PRIMARY KEY (turma_id, disciplina_id),
                                  FOREIGN KEY (turma_id) REFERENCES turma(id),
                                  FOREIGN KEY (disciplina_id) REFERENCES disciplina(id)
);
