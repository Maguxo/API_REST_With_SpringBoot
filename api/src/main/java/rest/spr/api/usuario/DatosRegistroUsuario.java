package rest.spr.api.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroUsuario(
        Long id,
        @NotNull
        String nombre,
        @NotNull
        @Email
        String email,
        @NotNull
        String contrasena) {
}
