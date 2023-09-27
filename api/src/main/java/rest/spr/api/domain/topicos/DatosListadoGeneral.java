package rest.spr.api.domain.topicos;

import rest.spr.api.domain.curso.Curso;
import rest.spr.api.domain.curso.DatosListadoCursoEspecifico;
import rest.spr.api.domain.respuesta.DatosListadoRespuestaEspecifico;
import rest.spr.api.domain.usuario.DatoslistadoUsuarioEspecifico;
import rest.spr.api.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosListadoGeneral(String titulo, String mensaje, LocalDateTime fecha,
                                  String status, DatoslistadoUsuarioEspecifico usuarioEspecifico,
                                  DatosListadoCursoEspecifico cursoEspecifico,
                                  DatosListadoRespuestaEspecifico respuesta) {


}
