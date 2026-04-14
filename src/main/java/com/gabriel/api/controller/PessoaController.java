package com.gabriel.api.controller;

import com.gabriel.api.dto.PessoaRequest;
import com.gabriel.api.dto.PessoaResponse;
import com.gabriel.api.entity.Pessoa;
import com.gabriel.api.mapper.PessoaMapper;
import com.gabriel.api.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService service;
    private final PessoaMapper pessoaMapper;

    @PostMapping
    public ResponseEntity<PessoaResponse> criar(@RequestBody @Valid PessoaRequest request) {
        Pessoa pessoaSalva = service.salvar(request);

        PessoaResponse response = pessoaMapper.toResponse(pessoaSalva);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> listar() {

        List<PessoaResponse> response = service.listar()
                .stream()
                .map(pessoaMapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> buscarPorId(@PathVariable Long id) {

        Pessoa pessoa = service.buscarPorId(id);

        PessoaResponse response = pessoaMapper.toResponse(pessoa);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponse> atualizar(@PathVariable Long id,
                                                    @RequestBody @Valid PessoaRequest request) {

        Pessoa pessoaAtualizada = service.atualizar(id, request);

        PessoaResponse response = pessoaMapper.toResponse(pessoaAtualizada);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}