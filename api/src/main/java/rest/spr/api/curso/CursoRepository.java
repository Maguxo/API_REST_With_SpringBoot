package rest.spr.api.curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    //Page<Curso> findByActivoTrue(Pageable paginacion); //esto me ayudara que el controler solo muestre los cursos que estan activos.
}
