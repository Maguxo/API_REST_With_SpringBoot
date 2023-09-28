package rest.spr.api.controller;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rest.spr.api.domain.respuesta.*;
import java.net.URI;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
    @Autowired
    public RespuestaRepository respuestaRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaRespuesta> insertarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta,
                                                                     UriComponentsBuilder uriComponentsBuilder){
        Respuesta respuesta= respuestaRepository.save(new Respuesta(datosRegistroRespuesta));
        DatosRespuestaRespuesta datosRespuestaRespuesta= new DatosRespuestaRespuesta(respuesta.getId(),respuesta.getMensaje(),
                respuesta.getFecha(),respuesta.getId(),respuesta.getSolucion());
        URI uri= uriComponentsBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();
        return ResponseEntity.created(uri).body(datosRespuestaRespuesta);
    }
    @GetMapping
    public ResponseEntity<Page<DatosListadoRespuesta>> listaRespuesta(@PageableDefault(size=3) Pageable paginacion){
        //return respuestaRepository.findAll().stream().map(DatosListadoRespuesta::new).toList();
        return ResponseEntity.ok(respuestaRepository.findAll(paginacion).map(DatosListadoRespuesta::new));
    }
    @PutMapping
    @Transactional
    public ResponseEntity actuaizarRespuestsa(@RequestBody @Valid DatosActualizarRespuesta datosActualizarRespuesta){
        Respuesta respuesta= respuestaRepository.getReferenceById(datosActualizarRespuesta.id());
        respuesta.actualizarRespuesta(datosActualizarRespuesta);
     return ResponseEntity.ok(new DatosRespuestaRespuesta(respuesta.getId(),respuesta.getMensaje(),
             respuesta.getFecha(),respuesta.getId(),respuesta.getSolucion()));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id) {
        Respuesta respuesta= respuestaRepository.getReferenceById(id);
        respuestaRepository.delete(respuesta);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaRespuesta> retornarDatoRespuesta(@PathVariable Long id) {
        Respuesta respuesta= respuestaRepository.getReferenceById(id);
         var datoRespuesta= new DatosRespuestaRespuesta(respuesta.getId(),respuesta.getMensaje(),
                 respuesta.getFecha(),respuesta.getId(),respuesta.getSolucion());
         return  ResponseEntity.ok(datoRespuesta);
    }

}
