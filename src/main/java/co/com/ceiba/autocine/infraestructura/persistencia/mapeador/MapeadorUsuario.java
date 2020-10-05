package co.com.ceiba.autocine.infraestructura.persistencia.mapeador;

import co.com.ceiba.autocine.dominio.modelo.Usuario;
import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadTipoDocumento;
import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadUsuario;

public final class MapeadorUsuario {

    private MapeadorUsuario() {}

    public static Usuario toDomain(EntidadUsuario entity) {
        return new Usuario(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getTipoDocumento().getId(),
                entity.getNumeroDocumento(),
                entity.getContrasena(),
                MapeadorRol.toDomainSet(entity.getRoles())
        );
    }

    public static EntidadUsuario toEntity(Usuario user) {
        EntidadUsuario entity = new EntidadUsuario();
        entity.setId(user.getId());
        entity.setNombre(user.getNombre());
        entity.setApellido(user.getApellido());
        entity.setContrasena(user.getContrasena());
        entity.setNumeroDocumento(user.getIdDocumento());

        EntidadTipoDocumento documentType = new EntidadTipoDocumento();
        documentType.setId(user.getTipoDocumento());
        entity.setTipoDocumento(documentType);
        entity.setRoles(MapeadorRol.toEntitySet(user.getRoles()));

        return entity;
    }

}
