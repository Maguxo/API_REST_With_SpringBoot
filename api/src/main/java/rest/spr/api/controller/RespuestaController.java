package rest.spr.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import rest.spr.api.domain.respuesta.*;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
    @Autowired
    public RespuestaRepository respuestaRepository;

    @PostMapping
    public void insertarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta){
        this.respuestaRepository.save(new Respuesta(datosRegistroRespuesta));
    }
    @GetMapping
    public Page<DatosListadoRespuesta> listaRespuesta(@PageableDefault(size=3) Pageable paginacion){
        //return respuestaRepository.findAll().stream().map(DatosListadoRespuesta::new).toList();
        return respuestaRepository.findAll(paginacion).map(DatosListadoRespuesta::new);
    }
    @PutMapping
    @Transactional
    public void actuaizarRespuestsa(@RequestBody @Valid DatosActualizarRespuesta datosActualizarRespuesta){
        Respuesta respuesta= respuestaRepository.getReferenceById(datosActualizarRespuesta.id());
        respuesta.actualizarRespuesta(datosActualizarRespuesta);
    }
    @DeleteMapping("{id}")
    @Transactional
    public void eliminarRespuesta(@PathVariable Long id) {
        Respuesta respuesta= respuestaRepository.getReferenceById(id);
        respuestaRepository.delete(respuesta);
    }

}
