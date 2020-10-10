package co.com.ceiba.autocine.aplicacion.manejadores;

import co.com.ceiba.autocine.dominio.modelo.Vehiculo;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioVehiculo;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ManejadorObtenerVehiculo {

    private final RepositorioVehiculo repositorio;

    public ManejadorObtenerVehiculo(RepositorioVehiculo repositorio) {
        this.repositorio = repositorio;
    }

    public Vehiculo obtenerPorPlaca(String placa) {
        return repositorio.obtenerPorPlaca(placa);
    }

    public Set<Vehiculo> obtenerPorIdUsuario(long idUsuario) {
        return repositorio.obtenerPorIdUsuario(idUsuario);
    }

}
