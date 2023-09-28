package rest.spr.api.domain.usuario;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioResository extends JpaRepository<Usuario,Long> {

}
