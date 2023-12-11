CREATE TABLE aluno (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL
);

CREATE TABLE turma (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL
);

CREATE TABLE aluno_turma (
                             aluno_id BIGINT,
                             turma_id BIGINT,
                             PRIMARY KEY (aluno_id, turma_id),
                             FOREIGN KEY (aluno_id) REFERENCES aluno(id),
                             FOREIGN KEY (turma_id) REFERENCES turma(id)
);
