package rest.spr.api.infra.security;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rest.spr.api.domain.autor.AutorRepository;

@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    private AutorRepository autorRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return autorRepository.findByNombre(username);
    }
}
