package co.com.ceiba.autocine.dominio.servicio;

import co.com.ceiba.autocine.dominio.modelo.Usuario;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearUsuario {

    private RepositorioUsuario repositorio;

    public ServicioCrearUsuario(RepositorioUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario ejecutar(Usuario usuario) {
        return this.repositorio.guardar(usuario);
    }

}
