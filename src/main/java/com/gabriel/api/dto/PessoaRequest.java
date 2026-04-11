package com.gabriel.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaRequest {

    @NotNull(message = "O nome é obrigatório.")
    private String nome;

    private String cpf;
    private String rg;

    private Long estadoCivilId;
    private Long grauInstrucaoId;
}