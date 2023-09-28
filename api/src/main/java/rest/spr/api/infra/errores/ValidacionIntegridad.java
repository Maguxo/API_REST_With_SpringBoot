package rest.spr.api.infra.errores;
/**CREATED BY Edgar M Gómez P
 * Backend Developer*/
public class ValidacionIntegridad extends RuntimeException {
    public ValidacionIntegridad(String s) {
        super(s);
    }
}
