CREATE TABLE Professor (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nome VARCHAR(255) NOT NULL
);

CREATE TABLE Disciplina (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            nome VARCHAR(255) NOT NULL,
                            professor_id BIGINT,
                            FOREIGN KEY (professor_id) REFERENCES Professor(id)
);
