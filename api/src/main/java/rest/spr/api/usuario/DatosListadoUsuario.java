package rest.spr.api.usuario;

public record DatosListadoUsuario(String nombre, String email) {

    public DatosListadoUsuario(Usuario usuario){
        this(usuario.getNombre(), usuario.getEmail());
    }
}
