package com.gabriel.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record PessoaRequest(

        @NotNull(message = "O nome é obrigatório.")
        String nome,

        @NotNull(message = "O CPF é obrigatório.")
        String cpf,

        @NotNull(message = "O RG é obrigatório.")
        String rg,

        @NotNull(message = "O estado civil é obrigatório.")
        Long estadoCivilId,

        @NotNull(message = "O grau de instrução é obrigatório.")
        Long grauInstrucaoId
) {
}

/*@Getter
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
}*/