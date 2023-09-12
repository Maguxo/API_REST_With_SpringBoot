package rest.spr.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.spr.api.respuesta.DatosListadoRespuesta;
import rest.spr.api.respuesta.DatosRegistroRespuesta;
import rest.spr.api.respuesta.Respuesta;
import rest.spr.api.respuesta.RespuestaRepository;
import java.util.List;

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
    public List<DatosListadoRespuesta> listaRespuesta(){
        return respuestaRepository.findAll().stream().map(DatosListadoRespuesta::new).toList();
    }
}
