package co.com.ceiba.autocine.infraestructura.controlador;

import co.com.ceiba.autocine.aplicacion.comando.ComandoCompra;
import co.com.ceiba.autocine.aplicacion.comando.ComandoFuncion;
import co.com.ceiba.autocine.dominio.modelo.Funcion;
import co.com.ceiba.autocine.helper.AuthenticationHelper;
import co.com.ceiba.autocine.testdatabuilder.CompraTestDataBuilder;
import co.com.ceiba.autocine.testdatabuilder.FuncionTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class ControladorFuncionTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AuthenticationHelper helper;

    @Test
    void crearFuncion() throws Exception {
        // arrange
        String token = helper.authenticate(
                AuthenticationHelper.CORREO_ADMINISTRADOR,
                AuthenticationHelper.CONTRASENA_ADMINISTRADOR);

        ComandoFuncion funcion = new FuncionTestDataBuilder()
                .buildComando();

        // act
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders
                .post("/api/funcion")
                .header("authorization", "Bearer " + token)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(funcion))
        );

        // asserts
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void buscarPorFecha() throws Exception {
        // arrange
        String fechaInicio = "2020-10-10T00:00:00";
        String fechaFin = "2020-10-10T23:59:59";

        // act
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders
                .get("/api/funcion/{fechaInicio}/{fechaFin}", fechaInicio, fechaFin)
                .accept(MediaType.APPLICATION_JSON)
        );

        // assert
        resultActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void comprarTickets() throws Exception {
        // arrange
        String token = helper.authenticate(
                AuthenticationHelper.CORREO_USUARIO,
                AuthenticationHelper.CONTRASENA_USUARIO);

        ComandoCompra comandoCompra = new CompraTestDataBuilder()
                .buildComando();

        // act
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders
                .post("/api/funcion/comprar")
                .header("authorization", "Bearer " + token)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCompra))
        );

        // asserts
        resultActions
                .andDo(print())
                .andExpect(status().isOk());
    }
}