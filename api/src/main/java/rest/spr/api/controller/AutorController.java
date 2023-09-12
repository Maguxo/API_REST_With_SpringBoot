package rest.spr.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.spr.api.autor.Autor;
import rest.spr.api.autor.AutorRepository;
import rest.spr.api.autor.DatosRegistroAutor;
import rest.spr.api.autor.DatoslistadoAutor;

import java.util.List;

@RestController
@RequestMapping("/autors")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;
    @PostMapping
    public void insertarAutor(@RequestBody @Valid DatosRegistroAutor datosRegistroAutor){
        this.autorRepository.save(new Autor(datosRegistroAutor));
    }
    @GetMapping
    public List<DatoslistadoAutor> listaAutor(){
        return autorRepository.findAll().stream().map(DatoslistadoAutor::new).toList();
    }

}
