package com.agenda_service_back.prestadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrestadorMapper {
    @Mapping(source = "prestador_id", target = "prestador_id")
    PrestadorDTO toDTO(PrestadorEntity prestador);

    @Mapping(source = "prestadorDTO.prestador_id", target="prestador_id")
    PrestadorEntity toEntity(PrestadorDTO prestadorDTO);

    List<PrestadorDTO> toDTO(List<PrestadorEntity> prestadors);
    @Mappings({
            @Mapping(source = "prestadorDTO.prestador_id", target = "prestador_id"),
            @Mapping(source = "prestadorDTO.prestador_nome", target = "prestador_nome"),
            @Mapping(source = "prestadorDTO.prestador_email", target = "prestador_email"),
            @Mapping(source = "prestadorDTO.prestador_cnpj", target = "prestador_cnpj"),
            @Mapping(source = "prestadorDTO.prestador_endereco_id", target = "prestador_endereco_id"),
            @Mapping(source = "prestadorDTO.prestador_razao_social", target = "prestador_razao_social"),
            @Mapping(source = "prestadorDTO.prestador_senha", target = "prestador_senha"),
            @Mapping(source = "prestadorDTO.prestador_cpf", target = "prestador_cpf"),
    })
    PrestadorEntity updateEntity(PrestadorDTO prestadorDTO, PrestadorEntity prestador);
}
