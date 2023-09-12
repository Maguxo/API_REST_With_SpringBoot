CREATE TABLE usuarios(

            id BIGINT NOT NULL AUTO_INCREMENT,
            nombre VARCHAR (50)NOT NULL,
            email VARCHAR (100)NOT NULL UNIQUE,
            contrasena VARCHAR (100)NOT NULL,

            PRIMARY KEY(id)
);