package rest.spr.api.infra.security;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import rest.spr.api.domain.autor.AutorRepository;

import java.io.IOException;
@Component
public class SecurityFilter extends OncePerRequestFilter {//filtro
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AutorRepository autorRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        var AuthHeader= request.getHeader("Authorization");//.replace("Bearer","");
        if (AuthHeader != null) {
             var token = AuthHeader.replace("Bearer ", "");

            var subject= tokenService.getSubject(token);
            if (subject != null){ // reforzar el token
                //token valido
                var autor= autorRepository.findByNombre(subject);
                System.out.println(autor +"Veamos i anda vacio");
                var authentication= new UsernamePasswordAuthenticationToken(autor, null,
                        autor.getAuthorities());// Forzamos inici de sesión
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}
