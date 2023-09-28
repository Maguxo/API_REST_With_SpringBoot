package rest.spr.api.domain.topicos;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import java.time.LocalDateTime;

public record DatosListadoTopico(Long id,String titulo, String mensaje, LocalDateTime fecha, String status,
                                  Long autor_id, Long curso_id, Long respuesta_id){

    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(),topico.getMensaje(),topico.getFecha(), String.valueOf(topico.getStatus()),
                topico.getId(),topico.getId(),topico.getId());
    }
}
