ALTER TABLE respuestas ADD autor_id BIGINT NOT NULL;
ALTER TABLE respuestas ADD CONSTRAINT fk_respuestas_autor_id FOREIGN KEY (autor_id) REFERENCES autors(id);
