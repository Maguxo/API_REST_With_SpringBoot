package rest.spr.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import rest.spr.api.usuario.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioResository usuarioResository;

    @PostMapping
    public void insertarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario){
      this.usuarioResository.save(new Usuario(datosRegistroUsuario));
    }
    @GetMapping

           //List<>
    public Page<DatosListadoUsuario> listaUsuario(@PageableDefault(size=2) Pageable paginacion){
        return usuarioResository.findAll(paginacion).map(DatosListadoUsuario::new);
        //return usuarioResository.findAll().stream().map(DatosListadoUsuario::new).toList();
    }
    @PutMapping
    @Transactional
    public  void actualizaUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario){
        Usuario usuario= usuarioResository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizarUsuario(datosActualizarUsuario);
    }
    @DeleteMapping("{id}")
    @Transactional
    public void eliminarUsuario(@PathVariable Long id){
        Usuario usuario= usuarioResository.getReferenceById(id);
        usuarioResository.delete(usuario);
    }
}
