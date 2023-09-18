package rest.spr.api.controller;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rest.spr.api.domain.usuario.*;
import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioResository usuarioResository;

    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> insertarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario,
                                                                 UriComponentsBuilder uriComponentsBuilder){
      Usuario usuario= usuarioResository.save(new Usuario(datosRegistroUsuario));
      DatosRespuestaUsuario datosRespuestaUsuario= new DatosRespuestaUsuario(usuario.getId(),usuario.getNombre(),
              usuario.getEmail(),usuario.getContrasena()); // es buena practica
        //URI uri= "http://localhost:8080/usuarios/" +usuario.getId(); no es recomendable ya que al cambiar el servidor cambiaria la url.
        URI uri= uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(datosRespuestaUsuario);
      // debe retornar el 201 y URL debe encontrar al usuario
    }
    @GetMapping
           //List<>
    public ResponseEntity<Page<DatosListadoUsuario>> listaUsuario(@PageableDefault(size=2) Pageable paginacion){
        return ResponseEntity.ok(usuarioResository.findAll(paginacion).map(DatosListadoUsuario::new));
        //return usuarioResository.findAll().stream().map(DatosListadoUsuario::new).toList();
    }
    @PutMapping
    @Transactional
    public ResponseEntity actualizaUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario){
        Usuario usuario= usuarioResository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizarUsuario(datosActualizarUsuario);
        //return ResponseEntity.ok(usuario); no es bueno retornar directamente la entidad de la BD(Usuario) por la cual se crea un DTO para que interactue con la capa usuario.
          return ResponseEntity.ok(new DatosRespuestaUsuario(usuario.getId(),usuario.getNombre(),
                  usuario.getEmail(),usuario.getContrasena()));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id){ //ResponseEntity utilizarlo es buena practica.
        Usuario usuario= usuarioResository.getReferenceById(id);
        usuarioResository.delete(usuario);
        return ResponseEntity.noContent().build(); //Me muestra un 204 indicando que es lo que se espera.
    }//ResponseEntity maneja las respuestas http configurandola completamente la respuesta http.

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaUsuario> retornarDatosUsuario(@PathVariable Long id){
        Usuario usuario= usuarioResository.getReferenceById(id);
        var datosUsuario= new DatosRespuestaUsuario(usuario.getId(),usuario.getNombre(),
                usuario.getEmail(),usuario.getContrasena());
        return ResponseEntity.ok(datosUsuario);
    }//metodo para retornar un usuario en especifico
    //En caso de que el servidor no encuentre el usuario y me arroje 500 es necesario buscar una propiedad que me limite a mostrar
    // todo el stacktrace en Inmsonmia porque no es bueno que me muestre información que podría ser vulnerable como lo es mi identidad clase.
    // colocamos server.error.include-stacktraceaaaaaa=never en mi properties carpeta y asi nunca mostrará mi stack.
}
