package rest.spr.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import rest.spr.api.domain.autor.*;
import rest.spr.api.infra.security.DatosJWTToken;
import rest.spr.api.infra.security.TokenService;

import java.net.Authenticator;
import java.net.URI;

@RestController
@RequestMapping("/autors")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private TokenService tokenService;// llamamos al token

    @Autowired
    private AuthenticationManager authenticationManager; //Tengo que crear un metodo en la claseSecurityConfiguration paraque me valide de lo contrario no corre.


    @PostMapping
    public ResponseEntity autenticationAutor(@RequestBody @Valid DatosAutenticacionAutor datosAutenticacionAutor){
        Authentication AuthToken= new UsernamePasswordAuthenticationToken(
                datosAutenticacionAutor.nombre(),datosAutenticacionAutor.contrasena());
        var autorAutenticado= authenticationManager.authenticate(AuthToken);
        var JWTtoken= tokenService.generarToken((Autor) autorAutenticado.getPrincipal()); //generamos token.
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken)); //metodo para login.
    }
    /*@PostMapping
    public ResponseEntity<DatoRespuestaAutor> insertarAutor(@RequestBody @Valid DatosRegistroAutor datosRegistroAutor,
                                                            UriComponentsBuilder uriComponentsBuilder){
        Autor autor= autorRepository.save(new Autor(datosRegistroAutor));
        DatoRespuestaAutor datoRespuestaAutor= new DatoRespuestaAutor(autor.getId(),autor.getNombre(),
                autor.getEmail(),autor.getContrasena());
        URI uri= uriComponentsBuilder.path("/autors/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(datoRespuestaAutor);
    }*/
    @GetMapping
    public ResponseEntity<Page<DatoslistadoAutor>> listaAutor(@PageableDefault(size=3) Pageable paginacion){
           //List<>
        //return autorRepository.findAll().stream().map(DatoslistadoAutor::new).toList();
        return ResponseEntity.ok(autorRepository.findAll(paginacion).map(DatoslistadoAutor::new));
    }
    @PutMapping
    @Transactional
    public ResponseEntity actualizaAutor(@RequestBody @Valid DatosActualizarAutor datosActualizarAutor){
        Autor autor= autorRepository.getReferenceById(datosActualizarAutor.id());
        autor.actualizarAutor(datosActualizarAutor);
        return ResponseEntity.ok(new DatoRespuestaAutor(autor.getId(),autor.getNombre(),
                autor.getEmail(),autor.getContrasena()));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminaAutor(@PathVariable Long id){
        Autor autor= autorRepository.getReferenceById(id);
        autorRepository.delete(autor);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatoRespuestaAutor> retornarDatoAutor(@PathVariable Long id){
        Autor autor= autorRepository.getReferenceById(id);
        var datoAutor= new DatoRespuestaAutor(autor.getId(),autor.getNombre(),
                autor.getEmail(),autor.getContrasena());
        return ResponseEntity.ok(datoAutor);
    }
}
