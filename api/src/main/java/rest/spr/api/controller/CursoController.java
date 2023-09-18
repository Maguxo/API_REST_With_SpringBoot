package rest.spr.api.controller;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import rest.spr.api.domain.curso.Curso;
import rest.spr.api.domain.curso.DatosActualizarCurso;
import rest.spr.api.domain.curso.DatosListadoCurso;
import rest.spr.api.domain.curso.CursoRepository;
import rest.spr.api.domain.curso.DatosRegistroCurso;

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
    public Page<DatosListadoCurso> listaCursos(@PageableDefault(size=2) Pageable paginacion){
        return cursoRepository.findAll(paginacion).map(DatosListadoCurso::new); //Esta linea me mostrara todos los cursos disponibles que hay en la base de datos
       //return cursoRepository.findByActivoTrue(paginacion).map(DatosListadoCurso::new); //Encontrara listado por activo en la base de datos
    }
    @PutMapping
    @Transactional//(hace un commit)Ayuda a que se pueda realizar la trasacción o sino en inmsonmia me sigue apareciendo el mismo dato.
    public void actualizaCurso(@RequestBody @Valid DatosActualizarCurso datosActualizarCurso){
      Curso curso= cursoRepository.getReferenceById(datosActualizarCurso.id());
      curso.actualizarCurso(datosActualizarCurso);
    }
    @DeleteMapping("{id}")//me identifica la variable dinamico.
    @Transactional//para que tenga efecto los cambios.
    public  void eliminarCurso(@PathVariable Long id){
       Curso curso= cursoRepository.getReferenceById(id);
       cursoRepository.delete(curso);
    } //este metodo me elimina a nivel de base de datos o sea desde raíz.

}
/*//Delete logico.
    @DeleteMapping("{id}")//me identifica la variable dinamico.
    @Transactional//para que tenga efecto los cambios.
    public  void eliminarCurso(@PathVariable Long id){
       Curso curso= cursoRepository.getReferenceById(id);
       curso.desactivarCurso();
    }*/