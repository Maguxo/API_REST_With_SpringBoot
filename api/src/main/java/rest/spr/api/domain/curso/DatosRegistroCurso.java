package rest.spr.api.domain.curso;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso(
        Long id,
        @NotNull
        Nombre nombre,
        @NotNull
        Categoria categoria) {
}
