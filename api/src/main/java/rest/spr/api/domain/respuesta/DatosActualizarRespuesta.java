package rest.spr.api.domain.respuesta;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(@NotNull Long id,String mendje,Boolean solucion) {
}
