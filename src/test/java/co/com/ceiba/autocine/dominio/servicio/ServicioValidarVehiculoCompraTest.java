package co.com.ceiba.autocine.dominio.servicio;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import co.com.ceiba.autocine.dominio.modelo.Factura;
import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.dominio.modelo.Vehiculo;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioFactura;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioVehiculo;
import co.com.ceiba.autocine.testdatabuilder.FacturaTestDataBuilder;
import co.com.ceiba.autocine.testdatabuilder.FuncionTestDataBuilder;
import co.com.ceiba.autocine.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServicioValidarVehiculoCompraTest {

    @Mock
    private RepositorioFactura repositorioFactura;
    @Mock
    private RepositorioVehiculo repositorioVehiculo;

    private ServicioValidarVehiculoCompra servicioValidarVehiculoCompra;

    @BeforeEach
    void setUp() {
        servicioValidarVehiculoCompra = new ServicioValidarVehiculoCompra(repositorioFactura, repositorioVehiculo);
    }

    @Test
    void picoYPlacaTest() {
        // arrange
        long idUsuario = 1L;
        String placa = "ABC-123";
        Funcion funcion = new FuncionTestDataBuilder()
                .build();

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> servicioValidarVehiculoCompra.ejecutar(funcion, idUsuario, placa));

        // assert
        assertEquals(String.format(ServicioValidarVehiculoCompra.VEHICULO_RESTRINGIDO,
                placa, funcion.getFechaInicio().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))),
                exception.getMessage());
    }

    @Test
    void vehiculoNoExisteTest() {
        // arrange
        long idUsuario = 1L;
        String placa = "ABC-124";
        Funcion funcion = new FuncionTestDataBuilder()
                .build();

        when(repositorioVehiculo.obtenerPorPlaca(any()))
                .thenReturn(null);

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> servicioValidarVehiculoCompra.ejecutar(funcion, idUsuario, placa));

        // assert
        assertEquals(String.format(ServicioValidarVehiculoCompra.VEHICULO_NO_EXISTE, placa),
                exception.getMessage());
    }

    @Test
    void vehiculoNoTePerteneceTest() {
        // arrange
        long idUsuario = 1L;
        String placa = "ABC-124";
        Funcion funcion = new FuncionTestDataBuilder()
                .build();

        Vehiculo vehiculo = new VehiculoTestDataBuilder()
                .conPlaca("ABC-124")
                .conIdUsuario(2L)
                .build();

        when(repositorioVehiculo.obtenerPorPlaca(any()))
                .thenReturn(vehiculo);

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> servicioValidarVehiculoCompra.ejecutar(funcion, idUsuario, placa));

        // assert
        assertEquals(String.format(ServicioValidarVehiculoCompra.VEHICULO_NO_TE_PERTENECE, vehiculo.getPlaca()),
                exception.getMessage());
    }

    @Test
    void vehiculoYaPosseCupoTest() {
        long idUsuario = 1L;
        String placa = "ABC-124";
        Funcion funcion = new FuncionTestDataBuilder()
                .build();

        Vehiculo vehiculo = new VehiculoTestDataBuilder()
                .conPlaca("ABC-124")
                .conIdUsuario(idUsuario)
                .build();

        Factura factura = new FacturaTestDataBuilder()
                .build();

        when(repositorioVehiculo.obtenerPorPlaca(any()))
                .thenReturn(vehiculo);
        when(repositorioFactura.obtenerPorIdVehiculoYIdFuncion(any(Long.class), any(Long.class)))
                .thenReturn(factura);

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> servicioValidarVehiculoCompra.ejecutar(funcion, idUsuario, placa));

        // assert
        assertEquals(String.format(ServicioValidarVehiculoCompra.VEHICULO_YA_POSEE_CUPO, vehiculo.getPlaca()),
                exception.getMessage());
    }


}