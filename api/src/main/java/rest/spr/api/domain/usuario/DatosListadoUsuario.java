package rest.spr.api.domain.usuario;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
public record DatosListadoUsuario(Long id, String nombre, String email) {

    public DatosListadoUsuario(Usuario usuario){
        this(usuario.getId(),usuario.getNombre(), usuario.getEmail());
    }
}
