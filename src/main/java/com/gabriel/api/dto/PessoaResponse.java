package com.gabriel.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaResponse {

    private Long id;
    private String nome;
    private String cpf;
    private String rg;

    private Long estadoCivilId;
    private String estadoCivilNome;

    private Long grauInstrucaoId;
    private String grauInstrucaoDescricao;
}
