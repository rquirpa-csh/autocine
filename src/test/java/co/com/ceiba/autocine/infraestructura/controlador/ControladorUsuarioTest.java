package co.com.ceiba.autocine.infraestructura.controlador;

import co.com.ceiba.autocine.dominio.modelo.Usuario;
import co.com.ceiba.autocine.testdatabuilder.UsuarioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ControladorUsuarioTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void crearUsuario() throws Exception {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder()
                .build();

        // act
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders
                .post("/api/usuario")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)));

        // assert
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void buscarPorDocumento() throws Exception {
        // arrange
        Usuario maria = new UsuarioTestDataBuilder()
                .conTipoDocumento(2)
                .conIdDocumento(2345)
                .conNombre("Maria")
                .conApellido("Dolores")
                .build();

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders
                .get("/api/usuario/{tipoDocumento}/{idDocumento}",
                        maria.getTipoDocumento(), maria.getIdDocumento())
                .accept(MediaType.APPLICATION_JSON));

        // assert
        resultActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.nombre").value(maria.getNombre()))
                .andExpect(jsonPath("$.apellido").value(maria.getApellido()));
    }

}