package rest.spr.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import rest.spr.api.autor.*;

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
    public Page<DatoslistadoAutor> listaAutor(@PageableDefault(size=3) Pageable paginacion){
           //List<>
        //return autorRepository.findAll().stream().map(DatoslistadoAutor::new).toList();
        return autorRepository.findAll(paginacion).map(DatoslistadoAutor::new);
    }
    @PutMapping
    @Transactional
    public void actualizaAutor(@RequestBody @Valid DatosActualizarAutor datosActualizarAutor){
        Autor autor= autorRepository.getReferenceById(datosActualizarAutor.id());
        autor.actualizarAutor(datosActualizarAutor);
    }
    @DeleteMapping("{id}")
    @Transactional
    public void eliminaAutor(@PathVariable Long id){
        Autor autor= autorRepository.getReferenceById(id);
        autorRepository.delete(autor);
    }
}
