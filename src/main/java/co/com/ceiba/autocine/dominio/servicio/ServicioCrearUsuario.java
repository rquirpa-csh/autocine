package co.com.ceiba.autocine.dominio.servicio;

import co.com.ceiba.autocine.dominio.exception.ApplicationException;
import co.com.ceiba.autocine.dominio.modelo.Usuario;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearUsuario {

    private final RepositorioUsuario repositorio;

    public ServicioCrearUsuario(RepositorioUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario ejecutar(Usuario usuario) {
        if (this.repositorio.obtenerPorCorreo(usuario.getCorreo()) != null) {
            throw new ApplicationException("El correo ya esta registrado");
        }
        return this.repositorio.guardar(usuario);
    }

}
