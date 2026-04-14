package com.gabriel.api.dto;

import jakarta.validation.constraints.NotNull;

public class PessoaRequest {

    private String nome;
    private String cpf;
    private String rg;
    private Long estadoCivilId;
    private Long grauInstrucaoId;

    public PessoaRequest() {
    }

    public PessoaRequest(String nome, String cpf, String rg, Long estadoCivilId, Long grauInstrucaoId) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.estadoCivilId = estadoCivilId;
        this.grauInstrucaoId = grauInstrucaoId;
    }

    @NotNull(message = "O nome é obrigatório.")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Long getEstadoCivilId() {
        return estadoCivilId;
    }

    public void setEstadoCivilId(Long estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }

    public Long getGrauInstrucaoId() {
        return grauInstrucaoId;
    }

    public void setGrauInstrucaoId(Long grauInstrucaoId) {
        this.grauInstrucaoId = grauInstrucaoId;
    }
}