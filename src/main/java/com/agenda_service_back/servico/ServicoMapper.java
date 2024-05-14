package com.agenda_service_back.servico;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicoMapper {
    @Mapping(source = "servico_id", target = "servico_id")
    ServicoDTO toDTO(ServicoEntity servico);

    @Mapping(source = "servicoDTO.servico_id", target="servico_id")
    ServicoEntity toEntity(ServicoDTO servicoDTO);

    List<ServicoDTO> toDTO(List<ServicoEntity> servicos);
    @Mappings({
            @Mapping(source = "servicoDTO.servico_id", target = "servico_id"),
            @Mapping(source = "servicoDTO.servico_nome", target = "servico_nome"),
            @Mapping(source = "servicoDTO.servico_informacoes_extra", target = "servico_informacoes_extra"),
            @Mapping(source = "servicoDTO.servico_descricao", target = "servico_descricao"),
            @Mapping(source = "servicoDTO.servico_preco", target = "servico_preco"),
            @Mapping(source = "servicoDTO.servico_categoria_id", target = "servico_categoria_id"),
            @Mapping(source = "servicoDTO.servico_prestador_id", target = "servico_prestador_id"),
    })
    ServicoEntity updateEntity(ServicoDTO servicoDTO, ServicoEntity servico);
}
