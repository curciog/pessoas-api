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
public class PessoaIntegrationTest { // ajuste pro code review

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void deveCriarPessoaComSucesso() {
        PessoaRequest request = new PessoaRequest(
                "Teste JUnit",
                "00000000055",
                "1234567",
                1L,
                1L
        );

        ResponseEntity<String> response =
                restTemplate.postForEntity("/pessoas", request, String.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertTrue(response.getBody().contains("Teste JUnit"));
    }

    @Test
    void naoDevePermitirCpfDuplicado() {
        PessoaRequest request = new PessoaRequest(
                "Pessoa Duplicada",
                "88888888888",
                "7654321",
                1L,
                1L
        );

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