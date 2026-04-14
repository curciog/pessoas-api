package com.gabriel.api.service;

import com.gabriel.api.dto.PessoaRequest;
import com.gabriel.api.entity.EstadoCivil;
import com.gabriel.api.entity.GrauInstrucao;
import com.gabriel.api.entity.Pessoa;
import com.gabriel.api.exception.CpfDuplicadoException;
import com.gabriel.api.repository.EstadoCivilRepository;
import com.gabriel.api.repository.GrauInstrucaoRepository;
import com.gabriel.api.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final EstadoCivilRepository estadoCivilRepository;
    private final GrauInstrucaoRepository grauInstrucaoRepository;

    public Pessoa salvar(PessoaRequest request) {
        if (pessoaRepository.existsByCpf(request.cpf())) {
            throw new CpfDuplicadoException("Já existe uma pessoa cadastrada com esse CPF.");
        }

        EstadoCivil estadoCivil = estadoCivilRepository.findById(request.estadoCivilId())
                .orElseThrow(() -> new RuntimeException("Estado civil não encontrado."));

        GrauInstrucao grauInstrucao = grauInstrucaoRepository.findById(request.grauInstrucaoId())
                .orElseThrow(() -> new RuntimeException("Grau de instrução não encontrado."));

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(request.nome());
        pessoa.setCpf(request.cpf());
        pessoa.setRg(request.rg());
        pessoa.setEstadoCivil(estadoCivil);
        pessoa.setGrauInstrucao(grauInstrucao);

        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPorId(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada."));
    }

    public Pessoa atualizar(Long id, PessoaRequest request) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada."));

        if (!pessoa.getCpf().equals(request.cpf()) && pessoaRepository.existsByCpf(request.cpf())) {
            throw new RuntimeException("Já existe uma pessoa cadastrada com esse CPF.");
        }

        EstadoCivil estadoCivil = estadoCivilRepository.findById(request.estadoCivilId())
                .orElseThrow(() -> new RuntimeException("Estado civil não encontrado."));

        GrauInstrucao grauInstrucao = grauInstrucaoRepository.findById(request.grauInstrucaoId())
                .orElseThrow(() -> new RuntimeException("Grau de instrução não encontrado."));

        pessoa.setNome(request.nome());
        pessoa.setCpf(request.cpf());
        pessoa.setRg(request.rg());
        pessoa.setEstadoCivil(estadoCivil);
        pessoa.setGrauInstrucao(grauInstrucao);

        return pessoaRepository.save(pessoa);
    }

    public void deletar(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada."));

        pessoaRepository.delete(pessoa);
    }
}