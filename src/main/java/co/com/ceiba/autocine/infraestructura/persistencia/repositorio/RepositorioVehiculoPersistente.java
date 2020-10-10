package co.com.ceiba.autocine.infraestructura.persistencia.repositorio;

import co.com.ceiba.autocine.dominio.modelo.Vehiculo;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioVehiculo;
import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadVehiculo;
import co.com.ceiba.autocine.infraestructura.persistencia.mapeador.MapeadorVehiculo;
import co.com.ceiba.autocine.infraestructura.persistencia.repositorio.jpa.RepositorioVehiculoJPA;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class RepositorioVehiculoPersistente implements RepositorioVehiculo {

    private final RepositorioVehiculoJPA repositorio;

    public RepositorioVehiculoPersistente(RepositorioVehiculoJPA repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Vehiculo guardar(Vehiculo vehiculo) {
        EntidadVehiculo entidad = MapeadorVehiculo.toEntity(vehiculo);
        return MapeadorVehiculo.toDomain(repositorio.save(entidad));
    }

    @Override
    public Vehiculo obtenerPorPlaca(String placa) {
        EntidadVehiculo entidad = repositorio.obtenerPorPlaca(placa);
        return MapeadorVehiculo.toDomain(entidad);
    }

    @Override
    public Set<Vehiculo> obtenerPorIdUsuario(long idUsuario) {
        Set<EntidadVehiculo> entidadSet = repositorio.obtenerPorIdUsuario(idUsuario);
        return MapeadorVehiculo.toDomainSet(entidadSet);
    }
}
