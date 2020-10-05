package co.com.ceiba.autocine.infraestructura.persistencia.repositorio.jpa;

import co.com.ceiba.autocine.infraestructura.persistencia.entidad.EntidadFuncion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioFuncionJPA extends CrudRepository<EntidadFuncion, Long> {
}
