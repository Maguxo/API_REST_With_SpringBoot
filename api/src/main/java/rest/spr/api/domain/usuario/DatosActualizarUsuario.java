package rest.spr.api.domain.usuario;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(@NotNull Long id, String nombre,String email,String contrasena) {
}
