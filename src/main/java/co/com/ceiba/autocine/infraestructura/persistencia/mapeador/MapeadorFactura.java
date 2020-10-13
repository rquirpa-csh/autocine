package co.com.ceiba.autocine.infraestructura.persistencia.mapeador;

import co.com.ceiba.autocine.dominio.modelo.Factura;
import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadFactura;

public final class MapeadorFactura {

    private MapeadorFactura () {}

    public static Factura toDomain(EntidadFactura entity) {
        Factura factura = null;
        if (entity != null) {
            factura = new Factura(
                    entity.getId(),
                    entity.getNumeroEntradas(),
                    entity.getSubtotal(),
                    entity.getPorcentajeDescuento(),
                    entity.getDescuento(),
                    entity.getTotal(),
                    entity.getFechaCompra(),
                    MapeadorFuncion.toDomain(entity.getFuncion()),
                    MapeadorVehiculo.toDomain(entity.getVehiculo())
            );
        }
        return factura;
    }

    public static EntidadFactura toEntity(Factura factura) {
        EntidadFactura entity = new EntidadFactura();
        entity.setId(factura.getId());
        entity.setNumeroEntradas(factura.getNumeroEntradas());
        entity.setSubtotal(factura.getSubtotal());
        entity.setPorcentajeDescuento(factura.getPorcentajeDescuento());
        entity.setDescuento(factura.getDescuento());
        entity.setTotal(factura.getTotal());
        entity.setFechaCompra(factura.getFechaCompra());
        entity.setFuncion(MapeadorFuncion.toEntity(factura.getFuncion()));
        entity.setVehiculo(MapeadorVehiculo.toEntity(factura.getVehiculo()));
        return entity;
    }

}
