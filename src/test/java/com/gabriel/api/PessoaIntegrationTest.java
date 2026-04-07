package com.gabriel.api;

import com.gabriel.api.dto.PessoaRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PessoaIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void deveCriarPessoaComSucesso() {
        PessoaRequest request = new PessoaRequest();
        request.setNome("Teste JUnit");
        request.setCpf("12312312312");
        request.setRg("1234567");
        request.setEstadoCivilId(1L);
        request.setGrauInstrucaoId(1L);

        ResponseEntity<String> response =
                restTemplate.postForEntity("/pessoas", request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("Teste JUnit"));
    }

    @Test
    void naoDevePermitirCpfDuplicado() {
        PessoaRequest request = new PessoaRequest();
        request.setNome("Pessoa Duplicada");
        request.setCpf("88888888888");
        request.setRg("7654321");
        request.setEstadoCivilId(1L);
        request.setGrauInstrucaoId(1L);

        restTemplate.postForEntity("/pessoas", request, String.class);

        ResponseEntity<String> response =
                restTemplate.postForEntity("/pessoas", request, String.class);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertTrue(response.getBody().contains("Já existe uma pessoa cadastrada com esse CPF."));
    }

    @Test
    void deveListarPessoas() {
        ResponseEntity<String> response =
                restTemplate.getForEntity("/pessoas", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}