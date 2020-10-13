package co.com.ceiba.autocine.dominio.servicio;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import co.com.ceiba.autocine.dominio.modelo.Factura;
import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.dominio.modelo.Vehiculo;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioFactura;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioVehiculo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ServicioValidarVehiculoCompra {

    public static final String VEHICULO_RESTRINGIDO = "El vehiculo con placa %s, no puede ingresar el dia %s";
    public static final String VEHICULO_YA_POSEE_CUPO = "El vehiculo con placa %s, ya tiene un cupo asignado para esta funcion";
    public static final String VEHICULO_NO_EXISTE = "El vehiculo con placa %s, no existe";
    public static final String VEHICULO_NO_TE_PERTENECE = "El vehiculo con placa %s, se encuentra asignado a otro usuario";

    private final RepositorioFactura repositorioFactura;
    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioValidarVehiculoCompra(RepositorioFactura repositorioFactura, RepositorioVehiculo repositorioVehiculo) {
        this.repositorioFactura = repositorioFactura;
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public Vehiculo ejecutar(Funcion funcion, long idUsuario, String placa) {
        if (!validarPicoYPlaca(funcion.getFechaInicio(), placa)) {
            throw new ApplicationException(String.format(VEHICULO_RESTRINGIDO,
                    placa, funcion.getFechaInicio().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        }

        Vehiculo vehiculo = repositorioVehiculo.obtenerPorPlaca(placa);
        if (vehiculo == null) {
            throw new ApplicationException(String.format(VEHICULO_NO_EXISTE, placa));
        }

        if (vehiculo.getIdUsuario() != idUsuario) {
            throw new ApplicationException(String.format(VEHICULO_NO_TE_PERTENECE, vehiculo.getPlaca()));
        }

        Factura factura = repositorioFactura.obtenerPorIdVehiculoYIdFuncion(vehiculo.getId(), funcion.getId());
        if (factura != null) {
            throw new ApplicationException(String.format(VEHICULO_YA_POSEE_CUPO, vehiculo.getPlaca()));
        }

        return vehiculo;
    }

    public boolean validarPicoYPlaca(LocalDateTime fechaInicio, String placa) {
        int diaFuncion = fechaInicio.getDayOfMonth();
        int ultimoDigitoPlaca = Character.getNumericValue(placa.charAt(6));

        int moduloPlaca = ultimoDigitoPlaca % 2;
        int moduloDia = diaFuncion % 2;

        return moduloDia != moduloPlaca;
    }

}
