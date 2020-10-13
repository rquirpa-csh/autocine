package co.com.ceiba.autocine.infraestructura.controlador;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import org.springframework.validation.Errors;

public class ControladorBase {
    protected void validarErrores(Errors errors) {
        if (errors.hasErrors()) {
            throw new ApplicationException(errors);
        }
    }
}
