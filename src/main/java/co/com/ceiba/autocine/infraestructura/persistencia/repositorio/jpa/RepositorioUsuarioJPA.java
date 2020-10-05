package co.com.ceiba.autocine.infraestructura.persistencia.repositorio.jpa;

import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuarioJPA extends CrudRepository<EntidadUsuario, Long> {
}
