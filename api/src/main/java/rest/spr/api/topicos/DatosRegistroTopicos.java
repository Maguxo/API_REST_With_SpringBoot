package rest.spr.api.topicos;

import rest.spr.api.modelo.Curso;
import rest.spr.api.modelo.Usuario;

public record DatosRegistroTopicos(String titulo, String mensaje, String fechaCreacion, StatusTopico estatusTopico,
                                   Usuario autor, Curso curso) {
}
