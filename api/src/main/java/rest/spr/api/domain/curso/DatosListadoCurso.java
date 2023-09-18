package rest.spr.api.domain.curso;

public record DatosListadoCurso(Long id,String nombre, String categoria) {

    public DatosListadoCurso(Curso curso){ //se crea el constructor para que me mapee lo que solo quiero que me muestre.
        this(curso.getId(),curso.getNombre().toString(),curso.getCategoria().toString());
    }
}
