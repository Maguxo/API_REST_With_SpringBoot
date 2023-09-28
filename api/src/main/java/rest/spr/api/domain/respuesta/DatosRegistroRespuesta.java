package rest.spr.api.domain.respuesta;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroRespuesta(
        Long id,
        @NotNull
        String mensaje,
        @NotNull
        LocalDateTime fecha,
        @NotNull
        Long autor_id,
        @NotNull
        Boolean solucion){
}
