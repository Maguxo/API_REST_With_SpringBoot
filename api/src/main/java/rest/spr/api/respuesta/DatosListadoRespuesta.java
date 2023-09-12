package rest.spr.api.respuesta;

import java.time.LocalDateTime;

public record DatosListadoRespuesta(String mensaje, LocalDateTime fecha, Boolean solucion) {

    public DatosListadoRespuesta(Respuesta respuesta){
        this(respuesta.getMensaje(),respuesta.getFecha(),respuesta.getSolucion());
    }
}
