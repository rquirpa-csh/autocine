package co.com.ceiba.autocine.dominio.servicio;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import co.com.ceiba.autocine.dominio.modelo.Factura;
import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.dominio.modelo.Vehiculo;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioFactura;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioFuncion;
import co.com.ceiba.autocine.testdatabuilder.FacturaTestDataBuilder;
import co.com.ceiba.autocine.testdatabuilder.FuncionTestDataBuilder;
import co.com.ceiba.autocine.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServicioCrearFacturaTest {

    private final LocalDateTime Lunes = LocalDateTime.parse("2020-10-05T14:00:00");
    private final LocalDateTime Martes = LocalDateTime.parse("2020-10-06T14:00:00");
    private final LocalDateTime Miercoles = LocalDateTime.parse("2020-10-07T14:00:00");

    @Mock
    private RepositorioFactura repositorioFactura;
    @Mock
    RepositorioFuncion repositorioFuncion;

    private ServicioCrearFactura servicioCrearFactura;

    @BeforeEach
    void setUp() {
        servicioCrearFactura = new ServicioCrearFactura(repositorioFactura, repositorioFuncion);
    }

    @Test
    void descuentoLunesTest() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder()
                .conFecha(Lunes)
                .build();

        Vehiculo vehiculo = new VehiculoTestDataBuilder()
                .build();

        when(repositorioFactura.buscarPorIdVehiculoIdFechaComprar(any(Long.class), any()))
                .thenReturn(ServicioCrearFactura.LIMITE_LEALTAD);

        // act
        double porcentajeDescuento = servicioCrearFactura.calcularPorcentajeDescuento(funcion, vehiculo);

        // assert
        assertEquals(0.1d, porcentajeDescuento);
    }

    @Test
    void descuentoMartesTest() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder()
                .conFecha(Martes)
                .build();

        Vehiculo vehiculo = new VehiculoTestDataBuilder()
                .build();

        when(repositorioFactura.buscarPorIdVehiculoIdFechaComprar(any(Long.class), any()))
                .thenReturn(ServicioCrearFactura.LIMITE_LEALTAD);

        // act
        double porcentajeDescuento = servicioCrearFactura.calcularPorcentajeDescuento(funcion, vehiculo);

        // assert
        assertEquals(0.1d, porcentajeDescuento);
    }

    @Test
    void descuentoEcologicoTest() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder()
                .conFecha(Miercoles)
                .build();

        Vehiculo vehiculo = new VehiculoTestDataBuilder()
                .conEcologico(true)
                .build();

        when(repositorioFactura.buscarPorIdVehiculoIdFechaComprar(any(Long.class), any()))
                .thenReturn(ServicioCrearFactura.LIMITE_LEALTAD);

        // act
        double porcentajeDescuento = servicioCrearFactura.calcularPorcentajeDescuento(funcion, vehiculo);

        // assert
        assertEquals(0.1d, porcentajeDescuento);
    }

    @Test
    void descuentoLealtadTest() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder()
                .conFecha(Miercoles)
                .build();

        Vehiculo vehiculo = new VehiculoTestDataBuilder()
                .conEcologico(false)
                .build();

        when(repositorioFactura.buscarPorIdVehiculoIdFechaComprar(any(Long.class), any()))
                .thenReturn(ServicioCrearFactura.LIMITE_LEALTAD + 1);

        // act
        double porcentajeDescuento = servicioCrearFactura.calcularPorcentajeDescuento(funcion, vehiculo);

        // assert
        assertEquals(0.1d, porcentajeDescuento);
    }

    @Test
    void limiteDescuentoMaximoTest() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder()
                .conFecha(Lunes)
                .build();

        Vehiculo vehiculo = new VehiculoTestDataBuilder()
                .conEcologico(true)
                .build();

        when(repositorioFactura.buscarPorIdVehiculoIdFechaComprar(any(Long.class), any()))
                .thenReturn(ServicioCrearFactura.LIMITE_LEALTAD + 1);

        // act
        double porcentajeDescuento = servicioCrearFactura.calcularPorcentajeDescuento(funcion, vehiculo);

        // assert
        assertEquals(0.2d, porcentajeDescuento);
    }

    @Test
    void agotadoTest() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder()
                .build();

        Vehiculo vehiculo = new VehiculoTestDataBuilder()
                .build();

        when(repositorioFuncion.actualizarDisponible(any(Long.class)))
                .thenReturn(0);

        // act
        ApplicationException exception = assertThrows(ApplicationException.class,
                () -> servicioCrearFactura.ejecutar(funcion, vehiculo, 3));

        // assert
        assertEquals(ServicioValidarFuncionCompra.CUPOS_AGOTADOS, exception.getMessage());
    }

    @Test
    void ejecutarTest() {
        // arrange
        Funcion funcion = new FuncionTestDataBuilder()
                .conFecha(Lunes)
                .build();

        Vehiculo vehiculo = new VehiculoTestDataBuilder()
                .conEcologico(true)
                .build();

        Factura mock = new FacturaTestDataBuilder()
                .conFuncion(funcion)
                .conVehiculo(vehiculo)
                .build();

        when(repositorioFuncion.actualizarDisponible(any(Long.class)))
                .thenReturn(1);

        when(repositorioFactura.crear(any()))
                .thenReturn(mock);

        // act
        Factura factura = servicioCrearFactura.ejecutar(funcion, vehiculo, 3);

        // assert
        assertEquals(factura.getVehiculo(), vehiculo);
        assertEquals(factura.getFuncion(), funcion);

    }

}