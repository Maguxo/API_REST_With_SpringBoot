package rest.spr.api.topicos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopicos(
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        LocalDateTime fecha,
        @NotNull
        StatusTopico status,
        @NotNull
        Long autor_id,
        @NotNull
        Long curso_id,
        @NotNull
        Long respuesta_id) {
}
