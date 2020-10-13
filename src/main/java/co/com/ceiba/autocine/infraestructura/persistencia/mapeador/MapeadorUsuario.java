package co.com.ceiba.autocine.infraestructura.persistencia.mapeador;

import co.com.ceiba.autocine.dominio.modelo.Usuario;
import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadUsuario;

public final class MapeadorUsuario {

    private MapeadorUsuario() {}

    public static Usuario toDomain(EntidadUsuario entity) {
        Usuario usuario = null;
        if (entity != null) {
            usuario = new Usuario(
                    entity.getId(),
                    entity.getCorreo(),
                    entity.getNombre(),
                    entity.getApellido(),
                    entity.getContrasena(),
                    MapeadorRol.toDomainSet(entity.getRoles())
            );
        }
        return usuario;
    }

    public static EntidadUsuario toEntity(Usuario user) {
        EntidadUsuario entity = new EntidadUsuario();
        entity.setId(user.getId());
        entity.setCorreo(user.getCorreo());
        entity.setNombre(user.getNombre());
        entity.setApellido(user.getApellido());
        entity.setContrasena(user.getContrasena());
        entity.setRoles(MapeadorRol.toEntitySet(user.getRoles()));

        return entity;
    }

}
