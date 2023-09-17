package rest.spr.api.autor;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarAutor(@NotNull Long id, String nombre, String email, String contrasena) {

}
