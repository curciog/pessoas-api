package com.gabriel.api.mapper;

import com.gabriel.api.dto.PessoaRequest;
import com.gabriel.api.dto.PessoaResponse;
import com.gabriel.api.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estadoCivil", ignore = true)
    @Mapping(target = "grauInstrucao", ignore = true)
    Pessoa toEntity(PessoaRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estadoCivil", ignore = true)
    @Mapping(target = "grauInstrucao", ignore = true)
    void updateEntityFromRequest(PessoaRequest request, @MappingTarget Pessoa pessoa);

    @Mapping(target = "estadoCivilId", source = "estadoCivil.id")
    @Mapping(target = "estadoCivilNome", source = "estadoCivil.nome")
    @Mapping(target = "grauInstrucaoId", source = "grauInstrucao.id")
    @Mapping(target = "grauInstrucaoDescricao", source = "grauInstrucao.descricao")
    PessoaResponse toResponse(Pessoa pessoa);
}
