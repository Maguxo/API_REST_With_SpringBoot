package rest.spr.api.domain.topicos;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.spr.api.domain.curso.CursoRepository;
import rest.spr.api.domain.respuesta.RespuestaRepository;
import rest.spr.api.domain.usuario.UsuarioResository;
import rest.spr.api.infra.errores.ValidacionIntegridad;

@Service
public class RegistroTopicoService {
    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private UsuarioResository usuarioResository;
    @Autowired
    private TopicosRepository topicosRepository;
    public DatosRespuestaTopicos registro(DatosRegistroTopicos datosRegistroTopicos){

        if(!usuarioResository.findById(datosRegistroTopicos.autor_id()).isPresent()){
            throw new ValidacionIntegridad("Este id para usuario no fue encontrado.");
        }
        if (!cursoRepository.findById(datosRegistroTopicos.curso_id()).isPresent()){
            throw new ValidacionIntegridad("Este id para curso no fue encontrado.");
        }
        if (datosRegistroTopicos.respuesta_id()!=null && !respuestaRepository.existsById(datosRegistroTopicos.respuesta_id())){
            throw new ValidacionIntegridad("Este id para respuesta no fue encontrado.");
        }

        var respuesta= respuestaRepository.findById(datosRegistroTopicos.respuesta_id()).get();
        var curso= cursoRepository.findById(datosRegistroTopicos.curso_id()).get();
        var autor= usuarioResository.findById(datosRegistroTopicos.autor_id()).get();

        var registrar= new Topico(null,datosRegistroTopicos.titulo(),datosRegistroTopicos.mensaje(),
                datosRegistroTopicos.fecha(),datosRegistroTopicos.status(),autor,curso,respuesta);

        topicosRepository.save(registrar);

       return new DatosRespuestaTopicos(registrar);
    }


}
