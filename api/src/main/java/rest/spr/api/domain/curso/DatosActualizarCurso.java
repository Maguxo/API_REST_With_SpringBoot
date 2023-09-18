package rest.spr.api.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso(@NotNull Long id, Nombre nombre, Categoria categoria) {
}
