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
import rest.spr.api.domain.curso.*;
import java.net.URI;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaCurso> insertarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso,
                                                             UriComponentsBuilder uriComponentsBuilder) {
        Curso curso= cursoRepository.save(new Curso(datosRegistroCurso));
        DatosRespuestaCurso datosRespuestaCurso= new DatosRespuestaCurso(curso.getId(),curso.getNombre(),curso.getCategoria());
        URI uri= uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(datosRespuestaCurso);
    }
    @GetMapping
    public ResponseEntity<Page<DatosListadoCurso>> listaCursos(@PageableDefault(size=2) Pageable paginacion){
        return ResponseEntity.ok(cursoRepository.findAll(paginacion).map(DatosListadoCurso::new)); //Esta linea me mostrara todos los cursos disponibles que hay en la base de datos
       //return cursoRepository.findByActivoTrue(paginacion).map(DatosListadoCurso::new); //Encontrara listado por activo en la base de datos
    }
    @PutMapping
    @Transactional//(hace un commit)Ayuda a que se pueda realizar la trasacción o sino en inmsonmia me sigue apareciendo el mismo dato.
    public ResponseEntity actualizaCurso(@RequestBody @Valid DatosActualizarCurso datosActualizarCurso){
      Curso curso= cursoRepository.getReferenceById(datosActualizarCurso.id());
      curso.actualizarCurso(datosActualizarCurso);
      return ResponseEntity.ok(new DatosRespuestaCurso(curso.getId(),curso.getNombre(),curso.getCategoria()));
    }
    @DeleteMapping("/{id}")//me identifica la variable dinamico.
    @Transactional//para que tenga efecto los cambios.
    public ResponseEntity eliminarCurso(@PathVariable Long id){
       Curso curso= cursoRepository.getReferenceById(id);
       cursoRepository.delete(curso);
       return ResponseEntity.noContent().build();
    } //este metodo me elimina a nivel de base de datos o sea desde raíz.

    @GetMapping("/{id}")//me identifica la variable dinamico.
    public ResponseEntity<DatosRespuestaCurso> RetornarDatoCurso(@PathVariable Long id){
        Curso curso= cursoRepository.getReferenceById(id);
        var datoCurso= new DatosRespuestaCurso(curso.getId(),curso.getNombre(),curso.getCategoria());
        return ResponseEntity.ok(datoCurso);
    }
}
/*//Delete logico.
    @DeleteMapping("{id}")//me identifica la variable dinamico.
    @Transactional//para que tenga efecto los cambios.
    public  void eliminarCurso(@PathVariable Long id){
       Curso curso= cursoRepository.getReferenceById(id);
       curso.desactivarCurso();
    }*/