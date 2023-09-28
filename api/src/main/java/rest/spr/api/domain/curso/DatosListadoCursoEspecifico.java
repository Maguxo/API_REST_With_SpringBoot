package rest.spr.api.domain.curso;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
public record DatosListadoCursoEspecifico(String nombre, String categoria) {

    public DatosListadoCursoEspecifico(Curso curso){
        this(curso.getNombre().toString(),curso.getCategoria().toString());
    }
}
