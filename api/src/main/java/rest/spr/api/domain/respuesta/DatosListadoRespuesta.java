package rest.spr.api.domain.respuesta;

import java.time.LocalDateTime;

public record DatosListadoRespuesta(Long id,String mensaje, LocalDateTime fecha, Long autor_id,Boolean solucion) {

    public DatosListadoRespuesta(Respuesta respuesta){
        this(respuesta.getId(),respuesta.getMensaje(),respuesta.getFecha(),respuesta.getId(),respuesta.getSolucion());
    }
}
