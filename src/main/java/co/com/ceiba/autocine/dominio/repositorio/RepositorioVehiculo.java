package co.com.ceiba.autocine.dominio.repositorio;

import co.com.ceiba.autocine.dominio.modelo.Vehiculo;

import java.util.Set;

public interface RepositorioVehiculo {

    Vehiculo guardar(Vehiculo vehiculo);

    Vehiculo obtenerPorPlaca(String placa);

    Set<Vehiculo> obtenerPorIdUsuario(long idUsuario);

}
