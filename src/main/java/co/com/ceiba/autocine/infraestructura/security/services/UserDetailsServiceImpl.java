package co.com.ceiba.autocine.infraestructura.security.services;

import co.com.ceiba.autocine.dominio.modelo.Usuario;
import co.com.ceiba.autocine.dominio.repositorio.RepositorioUsuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final RepositorioUsuario repositorioUsuario;

    public UserDetailsServiceImpl(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public UserDetails loadUserByUsername(String correo) {
        Usuario usuario = repositorioUsuario.obtenerPorCorreo(correo);
        return UserDetailsImpl.build(usuario);
    }

}
