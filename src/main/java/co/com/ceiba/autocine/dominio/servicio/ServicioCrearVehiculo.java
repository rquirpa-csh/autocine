package co.com.ceiba.autocine.dominio.servicio;


import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import co.com.ceiba.autocine.dominio.modelo.Vehiculo;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioVehiculo;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearVehiculo {

    public static final String ERROR_PLACA_YA_REGISTRADA = "El numero de placa ya esta registrado";

    private final RepositorioVehiculo repositorio;

    public ServicioCrearVehiculo(RepositorioVehiculo repositorio) {
        this.repositorio = repositorio;
    }

    public Vehiculo ejecutar(Vehiculo vehiculo) {
        Vehiculo existente = repositorio.obtenerPorPlaca(vehiculo.getPlaca());
        if (existente != null) {
            throw new ApplicationException(ERROR_PLACA_YA_REGISTRADA);
        }
        return repositorio.guardar(vehiculo);
    }

}
