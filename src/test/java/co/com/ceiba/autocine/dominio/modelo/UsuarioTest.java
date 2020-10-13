package co.com.ceiba.autocine.dominio.modelo;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import co.com.ceiba.autocine.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsuarioTest {

    @Test
    void nombreVacio() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> usuario.setNombre(""));

        // assert
        assertEquals(Usuario.ERROR_NOMBRE, exception.getMessage());
    }

    @Test
    void apellidoVacio() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> usuario.setApellido(""));

        // assert
        assertEquals(Usuario.ERROR_APELLIDO, exception.getMessage());
    }

    @Test
    void idCorreoNull() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> usuario.setCorreo(null));

        // assert
        assertEquals(Usuario.ERROR_CORREO, exception.getMessage());
    }

    @Test
    void contrasenaVacia() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> usuario.setContrasena(""));

        // assert
        assertEquals(Usuario.ERROR_CONTRASENA, exception.getMessage());
    }

    @Test
    void rolesNull() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> usuario.setRoles(null));

        // assert
        assertEquals(Usuario.ERROR_ROLES, exception.getMessage());
    }

}