package rest.spr.api.topicos;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id,String titulo, String mensaje,StatusTopico status) {
}
