package rest.spr.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.spr.api.usuario.DatosListadoUsuario;
import rest.spr.api.usuario.DatosRegistroUsuario;
import rest.spr.api.usuario.Usuario;
import rest.spr.api.usuario.UsuarioResository;

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
    public List<DatosListadoUsuario> listaUsuario(){
        return usuarioResository.findAll().stream().map(DatosListadoUsuario::new).toList();
    }
}
