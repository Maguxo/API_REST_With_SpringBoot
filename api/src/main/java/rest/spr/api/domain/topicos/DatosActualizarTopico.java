package rest.spr.api.domain.topicos;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id,String titulo, String mensaje,StatusTopico status) {
}
