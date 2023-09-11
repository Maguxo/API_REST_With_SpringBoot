CREATE TABLE topicos(

            id BIGING NOT NULL AUTO_INCREMENT,
            titulo VARCHAR (500)NOT NULL,
            mensaje VARCHAR (10000)NOT NULL,
            fechaCreacion DATETIME NOT NULL,
            status VARCHAR NOT NULL,
            autor INTEGER NOT NULL,
            curso INTEGER NOT NULL,
            respuesta INTEGER NOT NULL,

            CONSTRAINTS fk_autor_id FOREIGN KEY autor REFERENCES autor(id),
            CONSTRAINTS fk_curso_id FOREIGN KEY curso REFERENCES curso(id),
            CONSTRAINTS fk_respuesta_id FOREIGN respuesta REFERENCES respuesta(id),

            PRIMARY KEY(id)
);