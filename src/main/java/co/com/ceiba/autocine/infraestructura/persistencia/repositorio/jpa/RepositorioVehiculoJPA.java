package co.com.ceiba.autocine.infraestructura.persistencia.repositorio.jpa;

import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadVehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RepositorioVehiculoJPA extends CrudRepository<EntidadVehiculo, Long> {

    @Query("from vehiculos x where x.placa = ?1")
    EntidadVehiculo obtenerPorPlaca(String placa);

    @Query("from vehiculos x where x.usuario.id = ?1")
    Set<EntidadVehiculo> obtenerPorIdUsuario(long idUsuario);

}
