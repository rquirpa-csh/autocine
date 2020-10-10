package co.com.ceiba.autocine.aplicacion.manejadores;

import co.com.ceiba.autocine.dominio.modelo.Usuario;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerUsuario {

    private final RepositorioUsuario repositorio;

    public ManejadorObtenerUsuario(RepositorioUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario ejecutar(int tipoDocumento, long idDocumento) {
        return repositorio.obtenerPorDocumento(tipoDocumento, idDocumento);
    }

}
