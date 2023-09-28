package rest.spr.api.domain.respuesta;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import java.time.LocalDateTime;

public record DatosRespuestaRespuesta(Long id, String mensaje, LocalDateTime fecha, Long autor_id, Boolean solucion) {
}
