package rest.spr.api.domain.topicos;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import rest.spr.api.domain.curso.DatosListadoCursoEspecifico;
import rest.spr.api.domain.respuesta.DatosListadoRespuestaEspecifico;
import rest.spr.api.domain.usuario.DatoslistadoUsuarioEspecifico;
import java.time.LocalDateTime;

public record DatosListadoGeneral(String titulo, String mensaje, LocalDateTime fecha,
                                  String status, DatoslistadoUsuarioEspecifico usuarioEspecifico,
                                  DatosListadoCursoEspecifico cursoEspecifico,
                                  DatosListadoRespuestaEspecifico respuesta) {


}
