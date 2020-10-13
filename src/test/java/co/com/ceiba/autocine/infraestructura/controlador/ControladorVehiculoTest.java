package co.com.ceiba.autocine.infraestructura.controlador;

import co.com.ceiba.autocine.dominio.modelo.Vehiculo;
import co.com.ceiba.autocine.helper.AuthenticationHelper;
import co.com.ceiba.autocine.infraestructura.security.jwt.JwtUtils;
import co.com.ceiba.autocine.testdatabuilder.VehiculoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ControladorVehiculoTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AuthenticationHelper helper;

    @Test
    void crearVehiculo() throws Exception {
        // arrange
        String token = helper.authenticate(
                AuthenticationHelper.CORREO_USUARIO,
                AuthenticationHelper.CONTRASENA_USUARIO);

        Vehiculo vehiculo = new VehiculoTestDataBuilder().build();

        // act
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders
                .post("/api/vehiculo")
                .header("authorization", "Bearer " + token)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehiculo))
        );

        // assert
        resultActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.placa").value(vehiculo.getPlaca()))
                .andExpect(jsonPath("$.idUsuario").value(vehiculo.getIdUsuario()));
    }

    @Test
    void obtenerPorPlaca() throws Exception {
        // arrange
        String token = helper.authenticate(
                AuthenticationHelper.CORREO_USUARIO,
                AuthenticationHelper.CONTRASENA_USUARIO);

        Vehiculo vehiculo = new VehiculoTestDataBuilder()
                .conId(3)
                .conPlaca("BCD-123")
                .conIdUsuario(3)
                .build();

        // act
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders
                .get("/api/vehiculo/placa/{placa}", vehiculo.getPlaca())
                .header("authorization", "Bearer " + token)
                .accept(MediaType.APPLICATION_JSON)
        );

        // assert
        resultActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.placa").value(vehiculo.getPlaca()))
                .andExpect(jsonPath("$.idUsuario").value(vehiculo.getIdUsuario()));
    }

    @Test
    void obtenerPorUsuario() throws Exception {
        // arrange
        String token = helper.authenticate(
                AuthenticationHelper.CORREO_USUARIO,
                AuthenticationHelper.CONTRASENA_USUARIO);

        long idUsuario = 2;

        // act
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders
                .get("/api/vehiculo/usuario/{idUsuario}", idUsuario)
                .header("authorization", "Bearer " + token)
                .accept(MediaType.APPLICATION_JSON)
        );

        // assert
        resultActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

}