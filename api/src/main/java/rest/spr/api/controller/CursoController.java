package rest.spr.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.spr.api.curso.Curso;
import rest.spr.api.curso.CursoRepository;
import rest.spr.api.curso.DatosListadoCurso;
import rest.spr.api.curso.DatosRegistroCurso;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public void insertarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso) {
        this.cursoRepository.save(new Curso(datosRegistroCurso));
    }

    @GetMapping
    public List<DatosListadoCurso> listaCursos(){
        return cursoRepository.findAll().stream().map(DatosListadoCurso::new).toList();
    }
}
