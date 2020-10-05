package co.com.ceiba.autocine.infraestructura.persistencia.repositorio;

import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.testdatabuilder.FuncionTestDataBuilder;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RepositorioFuncionPersistenteTest {

    @Autowired
    private RepositorioFuncionPersistente repositorio;

    @Test
    void crearFuncion() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder()
                .build();

        // act
        Funcion funcionCreada = repositorio.guardar(funcion);

        // asserts
        assertTrue(funcionCreada.getId() > 0);
    }

}