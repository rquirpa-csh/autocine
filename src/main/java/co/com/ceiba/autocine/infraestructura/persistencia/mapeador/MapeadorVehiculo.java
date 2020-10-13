package co.com.ceiba.autocine.infraestructura.persistencia.mapeador;

import co.com.ceiba.autocine.dominio.modelo.Vehiculo;
import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadUsuario;
import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadVehiculo;

import java.util.HashSet;
import java.util.Set;

public class MapeadorVehiculo {

    private MapeadorVehiculo () {}

    public static Vehiculo toDomain(EntidadVehiculo entity) {
        Vehiculo vehiculo = null;
        if (entity != null) {
            vehiculo = new Vehiculo(
                    entity.getId(),
                    entity.getPlaca(),
                    entity.getUsuario().getId(),
                    entity.isEcologico()
            );
        }
        return vehiculo;
    }

    public static EntidadVehiculo toEntity(Vehiculo vehiculo) {
        EntidadVehiculo entity = new EntidadVehiculo();
        entity.setId(vehiculo.getId());
        entity.setPlaca(vehiculo.getPlaca());
        entity.setEcologico(vehiculo.isEcologico());

        EntidadUsuario entidadUsuario = new EntidadUsuario();
        entidadUsuario.setId(vehiculo.getIdUsuario());
        entity.setUsuario(entidadUsuario);
        return entity;
    }

    public static Set<Vehiculo> toDomainSet(Set<EntidadVehiculo> entitySet) {
        Set<Vehiculo> vehiculoSet = new HashSet<>();
        if (entitySet != null) {
            entitySet.forEach(entidadVehiculo -> vehiculoSet.add(toDomain(entidadVehiculo)));
        }
        return vehiculoSet;
    }

    public static Set<EntidadVehiculo> toEntitySet(Set<Vehiculo> vehiculoSet) {
        Set<EntidadVehiculo> entitySet = new HashSet<>();
        if (vehiculoSet != null) {
            vehiculoSet.forEach(vehiculo -> entitySet.add(toEntity(vehiculo)));
        }
        return entitySet;
    }

}
