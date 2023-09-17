CREATE TABLE topicos(
             id BIGINT NOT NULL AUTO_INCREMENT,
             titulo VARCHAR(200) NOT NULL UNIQUE,
             mensaje VARCHAR(10000) NOT NULL,
             fecha DATETIME NOT NULL,
             status VARCHAR(50) NOT NULL,
             autor_id BIGINT,
             curso_id BIGINT,
             respuesta_id BIGINT,

             PRIMARY KEY(id),

             CONSTRAINT fk_topicos_autor_id FOREIGN KEY(autor_id) REFERENCES autors(id),
             CONSTRAINT fk_topicos_curso_id FOREIGN KEY(curso_id) REFERENCES cursos(id),
             CONSTRAINT fk_topicos_respuesta_id FOREIGN KEY(respuesta_id) REFERENCES respuestas(id)

)ENGINE=INNODB;
