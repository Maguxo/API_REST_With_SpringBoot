CREATE TABLE respuestas(

            id BIGINT NOT NULL AUTO_INCREMENT,
            mensaje VARCHAR (10000)NOT NULL,
            fecha DATETIME NOT NULL,
            solucion TINYINT NOT NULL,

            PRIMARY KEY(id)
);