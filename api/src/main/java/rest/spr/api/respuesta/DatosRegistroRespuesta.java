package rest.spr.api.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import rest.spr.api.autor.Autor;

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
