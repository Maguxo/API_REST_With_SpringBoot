package rest.spr.api.curso;

public record DatosListadoCurso(String nombre, String categoria) {

    public DatosListadoCurso(Curso curso){ //se crea el constructor para que me mapee lo que solo quiero que me muestre.
        this(curso.getNombre().toString(),curso.getCategoria().toString());
    }
}
