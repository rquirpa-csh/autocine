package co.com.ceiba.autocine.infraestructura.persistencia.repositorio.jpa;

import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadFactura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RepositorioFacturaJPA extends CrudRepository<EntidadFactura, Long> {

    @Query("from facturas x where x.vehiculo.id = ?1 and x.funcion.id = ?2")
    EntidadFactura buscarPorIdVehiculoYIdFuncion(long idVehiculo, long idFuncion);

    @Query("select count(1) from facturas x join x.funcion y where x.vehiculo.id = ?1 and x.funcion.fechaInicio >= ?2")
    int buscarPorIdVehiculoIdFechaComprar(long idVehiculo, LocalDateTime fechaCompra);

}
