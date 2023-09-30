ALTER TABLE topicos DROP FOREIGN KEY fk_topicos_autor_id;

ALTER TABLE topicos ADD CONSTRAINT fk_topicos_usuarios_id FOREIGN KEY(autor_id) REFERENCES usuarios(id);