package rest.spr.api.autor;

public record DatoslistadoAutor(Long id,String nombre,String email) {

    public DatoslistadoAutor(Autor autor){
        this(autor.getId(), autor.getNombre(),autor.getEmail());
    }
}
