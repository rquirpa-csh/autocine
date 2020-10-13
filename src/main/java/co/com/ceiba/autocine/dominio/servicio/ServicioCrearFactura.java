package co.com.ceiba.autocine.dominio.servicio;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import co.com.ceiba.autocine.dominio.modelo.Factura;
import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.dominio.modelo.Vehiculo;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioFactura;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioFuncion;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Service
public class ServicioCrearFactura {

    private static final int DIAS_DESCUENTO = 60;
    private static final double DESCUENTO_DIAS = 0.1d;
    private static final double DESCUENTO_ECOLOGICO = 0.1d;
    private static final double DESCUENTO_LEALTAD = 0.1d;
    private static final double MAXIMO_DESCUENTO = 0.2d;
    public static final int LIMITE_LEALTAD = 5;

    private final RepositorioFactura repositorioFactura;
    private final RepositorioFuncion repositorioFuncion;

    public ServicioCrearFactura(RepositorioFactura repositorioFactura, RepositorioFuncion repositorioFuncion) {
        this.repositorioFactura = repositorioFactura;
        this.repositorioFuncion = repositorioFuncion;
    }

    public Factura ejecutar(Funcion funcion, Vehiculo vehiculo, int cantidadTickets) {
        int actualizados = repositorioFuncion.actualizarDisponible(funcion.getId());
        if (actualizados != 1) {
            throw new ApplicationException(ServicioValidarFuncionCompra.CUPOS_AGOTADOS);
        }

        double porcentajeDescuento = calcularPorcentajeDescuento(funcion, vehiculo);
        double subtotal = funcion.getCosto() * cantidadTickets;
        double descuento = subtotal * porcentajeDescuento;
        double total = subtotal - descuento;

        Factura facturaCompra = new Factura(
                0L,
                cantidadTickets,
                subtotal,
                porcentajeDescuento,
                descuento,
                total,
                LocalDateTime.now(),
                funcion,
                vehiculo
        );

        return repositorioFactura.crear(facturaCompra);
    }

    public double calcularPorcentajeDescuento(Funcion funcion, Vehiculo vehiculo) {
        DayOfWeek diaFuncion = funcion.getFechaInicio().getDayOfWeek();

        double descuentoAcumulado = 0d;

        if (diaFuncion == DayOfWeek.MONDAY || diaFuncion == DayOfWeek.TUESDAY) {
            descuentoAcumulado += DESCUENTO_DIAS;
        }

        if (vehiculo.isEcologico()) {
            descuentoAcumulado += DESCUENTO_ECOLOGICO;
        }

        if (descuentoAcumulado < MAXIMO_DESCUENTO) {
            int comprasPrevias = repositorioFactura.buscarPorIdVehiculoIdFechaComprar(vehiculo.getId(),
                    LocalDateTime.now().minusDays(DIAS_DESCUENTO));

            if (comprasPrevias > LIMITE_LEALTAD) {
                descuentoAcumulado += DESCUENTO_LEALTAD;
            }
        }

        return descuentoAcumulado;
    }


}
