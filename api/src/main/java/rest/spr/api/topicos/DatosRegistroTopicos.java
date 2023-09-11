package rest.spr.api.topicos;

import rest.spr.api.curso.Curso;
import rest.spr.api.respuesta.Respuesta;
import rest.spr.api.usuario.Usuario;

public record DatosRegistroTopicos(String titulo, String mensaje, String fechaCreacion, StatusTopico estatusTopico,
                                   Usuario autor, Curso curso, Respuesta respuesta) {
}
