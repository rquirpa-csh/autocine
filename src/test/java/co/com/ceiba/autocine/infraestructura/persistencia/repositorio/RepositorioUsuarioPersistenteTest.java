package co.com.ceiba.autocine.infraestructura.persistencia.repositorio;


import co.com.ceiba.autocine.dominio.modelo.Rol;
import co.com.ceiba.autocine.dominio.modelo.Usuario;
import static org.junit.jupiter.api.Assertions.*;

import co.com.ceiba.autocine.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;


@SpringBootTest
class RepositorioUsuarioPersistenteTest {

    @Autowired
    private RepositorioUsuarioPersistente repositorio;

    @Test
    void crearUsuarioTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder()
                .build();

        // act
        Usuario usuarioCreado = repositorio.guardar(usuario);

        // assert
        assertTrue(usuarioCreado.getId() > 0);
        assertEquals(usuarioCreado.getIdDocumento(), usuario.getIdDocumento());
    }

    @Test
    void actualizarUsuarioTest() {
        // arrange
        Set<Rol> roles = new HashSet<>();
        Rol rolUsuario = new Rol();
        rolUsuario.setId(Rol.ROL_USUARIO);
        roles.add(rolUsuario);

        Usuario usuario = new UsuarioTestDataBuilder()
                .conId(2)
                .conNombre("Maria Antonieta")
                .conApellido("Dolores")
                .conTipoDocumento(1)
                .conIdDocumento(2345)
                .conContrasena("2345")
                .conRoles(roles)
                .build();

        // act
        Usuario usuarioActualizado = repositorio.guardar(usuario);

        // assert
        assertEquals(2, usuarioActualizado.getId());
        assertEquals("Maria Antonieta", usuarioActualizado.getNombre());
    }

}