package rest.spr.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.spr.api.curso.Curso;
import rest.spr.api.curso.CursoRepository;
import rest.spr.api.curso.DatosRegistroCurso;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public void insertarCurso(@RequestBody DatosRegistroCurso datosRegistroCurso) {
        this.cursoRepository.save(new Curso(datosRegistroCurso));
    }
}
