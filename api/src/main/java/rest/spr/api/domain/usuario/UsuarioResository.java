package rest.spr.api.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.spr.api.domain.usuario.Usuario;

public interface UsuarioResository extends JpaRepository<Usuario,Long> {
}
