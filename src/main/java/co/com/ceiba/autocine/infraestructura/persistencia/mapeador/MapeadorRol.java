package co.com.ceiba.autocine.infraestructura.persistencia.mapeador;

import co.com.ceiba.autocine.dominio.modelo.Rol;
import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadRol;

import java.util.HashSet;
import java.util.Set;

public final class MapeadorRol {

    private MapeadorRol() {}

    public static Rol toDomain(EntidadRol entity) {
        Rol rol = new Rol();
        rol.setId(entity.getId());
        rol.setNombre(entity.getNombre());
        return rol;
    }

    public static EntidadRol toEntity(Rol rol) {
        EntidadRol entity = new EntidadRol();
        entity.setId(rol.getId());
        entity.setNombre(rol.getNombre());
        return entity;
    }

    public static Set<Rol> toDomainSet(Set<EntidadRol> entitySet) {
        Set<Rol> rolSet = new HashSet<>();
        if (entitySet != null) {
            entitySet.forEach(entidadRol -> rolSet.add(toDomain(entidadRol)));
        }
        return rolSet;
    }

    public static Set<EntidadRol> toEntitySet(Set<Rol> rolSet) {
        Set<EntidadRol> entitySet = new HashSet<>();
        if (rolSet != null) {
            rolSet.forEach(rol -> entitySet.add(toEntity(rol)));
        }
        return entitySet;
    }

}
