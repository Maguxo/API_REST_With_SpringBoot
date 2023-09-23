package rest.spr.api.controller;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.spr.api.domain.topicos.*;

@RestController
@ResponseBody
@RequestMapping("/topicos")
public class Topicoscontroller {

    @Autowired
    private RegistroTopicoService registroTopicoService;
    @Autowired// a nivel de testin no es recomendable
    //Se tendráproblemas al hacer pruebas unitarias
    private TopicosRepository topicosRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registroTopico(@RequestBody @Valid DatosRegistroTopicos datosRegistroTopicos){

        registroTopicoService.registro(datosRegistroTopicos);
        return ResponseEntity.ok(new DatosRespuestaTopicos(null,null,null,
                null,null,null,null,null));
    }
    /*@PostMapping
    public ResponseEntity<DatosRespuestaTopicos> insertarTopico(@RequestBody @Valid DatosRegistroTopicos datosRegistroTopicos,
                                                               UriComponentsBuilder uriComponentsBuilder) {
        Topico topico= topicosRepository.save(new Topico(datosRegistroTopicos));
        DatosRespuestaTopicos datosRespuestaTopicos= new DatosRespuestaTopicos(topico.getId(),topico.getTitulo(),
                topico.getMensaje(),topico.getFecha(),topico.getStatus(),topico.getId(),topico.getId(),topico.getId());
        URI uri= uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(datosRespuestaTopicos);
    }*/
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopico(@PageableDefault(size = 4) Pageable paginacion){ //para paginación muestra de datos.
        return ResponseEntity.ok(topicosRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }//@PageableDefault(size = 2) me envia 2 datos solamente

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico= topicosRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarTopico(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopicos(topico.getId(),topico.getTitulo(),
                topico.getMensaje(),topico.getFecha(),topico.getStatus(),topico.getId(),topico.getId(),topico.getId()));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public  ResponseEntity eliminaTopico(@PathVariable Long id){
        Topico topico= topicosRepository.getReferenceById(id);
        topicosRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public  ResponseEntity<DatosRespuestaTopicos> retornarDatoTopico(@PathVariable Long id){
        Topico topico= topicosRepository.getReferenceById(id);
        var datosTopico= new DatosRespuestaTopicos(topico.getId(),topico.getTitulo(),
                topico.getMensaje(),topico.getFecha(),topico.getStatus(),topico.getId(),topico.getId(),topico.getId());
        return ResponseEntity.ok(datosTopico);
    }
}
/*@GetMapping
    public List<DatosListadoTopico> listadoTopico(){ Me muestra todos los datos y para un negocio es malo
        return topicosRepository.findAll().stream().map(DatosListadoTopico::new).toList();
    }*/

  //spring.jpa.show-sql=true /=esta linea me muestra en la consola las consultas que se hacen en MySQL.
  //spring.jpa.properties.hibernate.format_sql=true /= me muestra de forma ordenada la query de la base de datos.


