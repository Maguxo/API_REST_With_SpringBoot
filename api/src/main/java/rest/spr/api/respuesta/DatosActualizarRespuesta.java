package rest.spr.api.respuesta;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(@NotNull Long id,String mendje,Boolean solucion) {
}
