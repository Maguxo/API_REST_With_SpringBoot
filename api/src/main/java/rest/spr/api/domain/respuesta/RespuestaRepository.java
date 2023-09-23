package rest.spr.api.domain.respuesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rest.spr.api.domain.topicos.StatusTopico;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta,Long> {

    @Query("""
            select r from Respuesta r
            where r.solucion= 0
            and 
            """)
    Respuesta seleccionarRespuestaEstatus(StatusTopico status);
}
