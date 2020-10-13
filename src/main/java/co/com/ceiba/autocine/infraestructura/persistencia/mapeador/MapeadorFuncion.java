package co.com.ceiba.autocine.infraestructura.persistencia.mapeador;

import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadFuncion;

import java.util.HashSet;
import java.util.Set;

public final class MapeadorFuncion {

    private MapeadorFuncion() {}

    public static Funcion toDomain(EntidadFuncion entity) {
        Funcion funcion = null;
        if (entity != null) {
            funcion = new Funcion(
                    entity.getId(),
                    entity.getNombre(),
                    entity.getFechaInicio(),
                    entity.getFechaFin(),
                    entity.getCapacidadTotal(),
                    entity.getCapacidadDisponible(),
                    entity.getCosto()
            );
        }
        return funcion;
    }

    public static EntidadFuncion toEntity(Funcion funcion) {
        EntidadFuncion entity = new EntidadFuncion();
        entity.setId(funcion.getId());
        entity.setNombre(funcion.getNombre());
        entity.setFechaInicio(funcion.getFechaInicio());
        entity.setFechaFin(funcion.getFechaFin());
        entity.setCapacidadTotal(funcion.getCapacidadTotal());
        entity.setCapacidadDisponible(funcion.getCapacidadDisponible());
        entity.setCosto(funcion.getCosto());
        return entity;
    }

    public static Set<Funcion> toDomainSet(Set<EntidadFuncion> entitySet) {
        Set<Funcion> funcionSet = new HashSet<>();
        if (entitySet != null) {
            entitySet.forEach(entidadFuncion -> funcionSet.add(toDomain(entidadFuncion)));
        }
        return funcionSet;
    }

    public static Set<EntidadFuncion> toEntitySet(Set<Funcion> funcionSet) {
        Set<EntidadFuncion> entitySet = new HashSet<>();
        if (funcionSet != null) {
            funcionSet.forEach(funcion -> entitySet.add(toEntity(funcion)));
        }
        return entitySet;
    }
}
