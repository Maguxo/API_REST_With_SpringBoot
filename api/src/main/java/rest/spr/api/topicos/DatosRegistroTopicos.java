package rest.spr.api.topicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import rest.spr.api.curso.Curso;
import rest.spr.api.respuesta.Respuesta;
import rest.spr.api.usuario.Usuario;

public record DatosRegistroTopicos(
        //@NotBlank
        String titulo,
        //@NotBlank
        String mensaje,
        //@NotBlank
        String fechaCreacion,
        //@NotBlank
        StatusTopico estatusTopico,
        //@NotNull
        //@Valid //valida que este completo los datos.
        Usuario autor,
        //@NotNull
        //@Valid
        Curso curso,
        //@NotNull
        //@Valid
        Respuesta respuesta) {
}
