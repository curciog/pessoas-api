package com.gabriel.api.mapper;

import com.gabriel.api.dto.PessoaResponse;
import com.gabriel.api.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    @Mapping(target = "estadoCivilId", source = "estadoCivil.id")
    @Mapping(target = "estadoCivilNome", source = "estadoCivil.nome")
    @Mapping(target = "grauInstrucaoId", source = "grauInstrucao.id")
    @Mapping(target = "grauInstrucaoDescricao", source = "grauInstrucao.descricao")
    PessoaResponse toResponse(Pessoa pessoa);
}
