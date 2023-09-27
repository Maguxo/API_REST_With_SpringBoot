package rest.spr.api.domain.respuesta;

import rest.spr.api.domain.autor.DatosListadoAutorEspecifico;
import java.time.LocalDateTime;

public record DatosListadoRespuestaEspecifico(String mensaje, LocalDateTime fecha,
                                              DatosListadoAutorEspecifico autor, Boolean solucion) {
}
