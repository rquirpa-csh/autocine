package co.com.ceiba.autocine.infraestructura.persistencia.repositorio;

import co.com.ceiba.autocine.dominio.modelo.Factura;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioFactura;
import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadFactura;
import co.com.ceiba.autocine.infraestructura.persistencia.mapeador.MapeadorFactura;
import co.com.ceiba.autocine.infraestructura.persistencia.repositorio.jpa.RepositorioFacturaJPA;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class RepositorioFacturaPersistente implements RepositorioFactura {

    private final RepositorioFacturaJPA repositorio;

    public RepositorioFacturaPersistente(RepositorioFacturaJPA repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Factura crear(Factura factura) {
        EntidadFactura entidadFactura = repositorio.save(MapeadorFactura.toEntity(factura));
        return MapeadorFactura.toDomain(entidadFactura);
    }

    @Override
    public Factura obtenerPorIdVehiculoYIdFuncion(long idVehiculo, long idFuncion) {
        EntidadFactura entidadFactura = this.repositorio.buscarPorIdVehiculoYIdFuncion(idVehiculo, idFuncion);
        return MapeadorFactura.toDomain(entidadFactura);
    }

    @Override
    public int buscarPorIdVehiculoIdFechaComprar(long idVehiculo, LocalDateTime fechaCompra) {
        return this.repositorio.buscarPorIdVehiculoIdFechaComprar(idVehiculo, fechaCompra);
    }
}
