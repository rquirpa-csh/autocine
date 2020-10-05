package co.com.ceiba.autocine.infraestructura.persistencia.repositorio;

import co.com.ceiba.autocine.dominio.modelo.Usuario;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioUsuario;
import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadUsuario;
import co.com.ceiba.autocine.infraestructura.persistencia.mapeador.MapeadorUsuario;
import co.com.ceiba.autocine.infraestructura.persistencia.repositorio.jpa.RepositorioUsuarioJPA;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioPersistente implements RepositorioUsuario {

    private RepositorioUsuarioJPA repositorio;

    public RepositorioUsuarioPersistente(RepositorioUsuarioJPA repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        EntidadUsuario entidad = repositorio.save(MapeadorUsuario.toEntity(usuario));
        return MapeadorUsuario.toDomain(entidad);
    }

}
