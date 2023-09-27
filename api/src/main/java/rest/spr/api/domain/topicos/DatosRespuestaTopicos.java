package rest.spr.api.domain.topicos;

import java.time.LocalDateTime;

public record DatosRespuestaTopicos(Long id, String titulo, String mensaje, LocalDateTime fecha,
                                    StatusTopico status, Long autor_id,Long curso_id, Long respuesta_id) {
    public DatosRespuestaTopicos(Topico registrar) {
        this(registrar.getId(), registrar.getTitulo(), registrar.getMensaje(),registrar.getFecha(),
                registrar.getStatus(), registrar.getId(), registrar.getId(), registrar.getId());
    }
}
