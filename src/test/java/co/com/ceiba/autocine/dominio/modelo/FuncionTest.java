package co.com.ceiba.autocine.dominio.modelo;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import co.com.ceiba.autocine.testdatabuilder.FuncionTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FuncionTest {

    @Test
    void nombreNull() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder().build();

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> funcion.setNombre(null));

        // assert
        assertEquals(Funcion.ERROR_NOMBRE, exception.getMessage());

    }

    @Test
    void fechaInicioNull() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder().build();

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> funcion.setFechaInicio(null));

        // assert
        assertEquals(Funcion.ERROR_FECHA_INICIO, exception.getMessage());
    }

    @Test
    void fechaFinNull() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder().build();

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> funcion.setFechaFin(null));

        // assert
        assertEquals(Funcion.ERROR_FECHA_FIN, exception.getMessage());
    }

    @Test
    void fechaFinInferiorAFechaInicio() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder().build();
        LocalDateTime fechaFin = LocalDateTime.parse("2020-10-05T12:00:00");

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> funcion.setFechaFin(fechaFin));

        // assert
        assertEquals(Funcion.ERROR_FECHA_FIN_INFERIOR, exception.getMessage());
    }

    @Test
    void capacidadTotalNegativa() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder().build();

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> funcion.setCapacidadTotal(-1));

        // assert
        assertEquals(Funcion.ERROR_CAPACIDAD_TOTAL, exception.getMessage());
    }

    @Test
    void capacidadDisponibleNegativa() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder().build();

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> funcion.setCapacidadDisponible(-1));

        // assert
        assertEquals(Funcion.ERROR_CAPACIDAD_DISPONIBLE, exception.getMessage());
    }

    @Test
    void capacidadDisponibleMayorATotal() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder().build();

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> funcion.setCapacidadDisponible(50));

        // assert
        assertEquals(Funcion.ERROR_CAPACIDAD_DISPONIBLE_MAYOR_A_TOTAL, exception.getMessage());
    }

    @Test
    void costoNegativo() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder().build();

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> funcion.setCosto(-10000d));

        // assert
        assertEquals(Funcion.ERROR_COSTO, exception.getMessage());
    }

}