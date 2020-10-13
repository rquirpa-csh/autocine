package co.com.ceiba.autocine.dominio.exception;

import org.springframework.validation.Errors;

public class ApplicationException extends RuntimeException {

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(Errors errors) {
        super(errors.getAllErrors().get(0).getDefaultMessage());
    }

}
