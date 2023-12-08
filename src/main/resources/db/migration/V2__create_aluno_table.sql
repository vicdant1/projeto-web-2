CREATE TABLE Aluno (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL
);

CREATE TABLE Turma (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL
);

CREATE TABLE Aluno_Turma (
                             aluno_id BIGINT,
                             turma_id BIGINT,
                             PRIMARY KEY (aluno_id, turma_id),
                             FOREIGN KEY (aluno_id) REFERENCES Aluno(id),
                             FOREIGN KEY (turma_id) REFERENCES Turma(id)
);
