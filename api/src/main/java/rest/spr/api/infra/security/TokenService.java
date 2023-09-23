package rest.spr.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rest.spr.api.domain.autor.Autor;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")// Llama a properties y su clave en la cual es: JWT-SECRET=doctorviajes
    private String apiSecret;//por la cual en la terminal cmd encripte con el comando SET JWT_SECRET=doctorviajes(variables de entorno)

    public String generarToken(Autor autor){ //genera token
        try {
            //Algorithm algorithm = Algorithm.HMAC256("doctorviajes"); //Nunca hacer esto.
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("rest api")
                    .withSubject(autor.getNombre())
                    .withClaim("id",autor.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
           throw new RuntimeException(exception);
        }

    }
    public String getSubject(String token){
        if(token == null){
            throw new RuntimeException("algo pasa");
        }
        DecodedJWT verifier= null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            System.out.println(algorithm +" este es el algoritmo");
            verifier = JWT.require(algorithm)
                    .withIssuer("rest api")
                    .build()
                    .verify(token);
            System.out.println(verifier +" este es el verifier");

            verifier.getSubject();

        } catch (JWTVerificationException exception){
            System.out.println(exception.toString() +"  si es es esto2");
        }
      if (verifier == null ||verifier.getSubject() == null){
          throw new RuntimeException("Verifier invalido");

      }
        return verifier.getSubject();
    }
    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }

}
