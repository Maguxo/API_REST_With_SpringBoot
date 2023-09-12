package rest.spr.api.autor;

public record DatoslistadoAutor(String nombre,String email) {

    public DatoslistadoAutor(Autor autor){
        this(autor.getNombre(),autor.getEmail());
    }
}
