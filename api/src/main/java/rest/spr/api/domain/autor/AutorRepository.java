package rest.spr.api.domain.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    UserDetails findByNombre(String username);//es llamadadesde security carpeta
    //en la clase Usuario debe mirarar qué nombre le dio para asi poder nombrar el metodo
    //Ejem: public String login, en esta clase poner findByLogin(...)
}
