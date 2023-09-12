package rest.spr.api.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioResository extends JpaRepository<Usuario,Long> {
}
