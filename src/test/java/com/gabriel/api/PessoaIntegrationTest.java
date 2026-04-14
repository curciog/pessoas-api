package com.gabriel.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabriel.api.dto.PessoaRequest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class PessoaIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarPessoaComSucesso() throws Exception {
        PessoaRequest request = new PessoaRequest(
                "Teste JUnit",
                "00005555556",
                "1234567",
                1L,
                1L
        );

        mockMvc.perform(post("/pessoas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Teste JUnit")));
    }

    @Test
    void naoDevePermitirCpfDuplicado() throws Exception {
        PessoaRequest request = new PessoaRequest(
                "Pessoa Duplicada",
                "00005555557",
                "7654321",
                1L,
                1L
        );

        mockMvc.perform(post("/pessoas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());

        mockMvc.perform(post("/pessoas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isConflict())
                .andExpect(content().string(containsString("Já existe uma pessoa cadastrada com esse CPF.")));
    }

    @Test
    void deveListarPessoas() throws Exception {
        mockMvc.perform(get("/pessoas"))
                .andExpect(status().isOk());
    }
}