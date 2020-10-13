package co.com.ceiba.autocine.dominio.servicio;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioFuncion;
import co.com.ceiba.autocine.testdatabuilder.FuncionTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServicioValidarFuncionCompraTest {

    @Mock
    private RepositorioFuncion repositorioFuncion;

    private ServicioValidarFuncionCompra servicioValidarFuncionCompra;

    @BeforeEach
    void setUp() {
        servicioValidarFuncionCompra = new ServicioValidarFuncionCompra(repositorioFuncion);
    }

    @Test
    void funcionNoExisteTest() {
        // arrange
        when(repositorioFuncion.obtenerPorId(any(Long.class))).thenReturn(null);

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> servicioValidarFuncionCompra.ejecutar(1));

        // assert
        assertEquals(ServicioValidarFuncionCompra.FUNCION_NO_EXISTE, exception.getMessage());
    }

    @Test
    void cuposAgotadosTest() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder()
                .conCapacidadDisponible(0)
                .build();

        when(repositorioFuncion.obtenerPorId(any(Long.class))).thenReturn(funcion);

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> servicioValidarFuncionCompra.ejecutar(funcion.getId()));

        // assert
        assertEquals(ServicioValidarFuncionCompra.CUPOS_AGOTADOS, exception.getMessage());
    }

}