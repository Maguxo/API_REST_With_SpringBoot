package rest.spr.api.infra.errores;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //Permite controlar  los errores.
public class TratadorDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }


    @ExceptionHandler(ValidationException.class)//
    public ResponseEntity erroresHandlerValidacionesDeIntegridad(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());    }

    @ExceptionHandler(ValidacionIntegridad.class)// para que sea lanzado.
    public ResponseEntity erroresHandlerValidacionesDeNegocio(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());//para seber si envie parametro completos o salieron mal. y que no deben estar vacíos.
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var errores= e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores); //Metodo que  lanza los errores especificos
    }
    private record DatosErrorValidacion(String campo, String error){
        public DatosErrorValidacion(FieldError fieldError){
            this(fieldError.getField(),fieldError.getDefaultMessage());
        }}
}
