package rest.spr.api.domain.autor;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/

public record DatoslistadoAutor(Long id,String nombre,String email) {

    public DatoslistadoAutor(Autor autor){
        this(autor.getId(), autor.getNombre(),autor.getEmail());
    }
}
