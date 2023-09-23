package rest.spr.api.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioResository extends JpaRepository<Usuario,Long> {

}
