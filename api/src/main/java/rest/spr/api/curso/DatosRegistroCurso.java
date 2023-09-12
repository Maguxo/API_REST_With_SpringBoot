package rest.spr.api.curso;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso(
        Long id,
        @NotNull
        Nombre nombre,
        @NotNull
        Categoria categoria) {
}
