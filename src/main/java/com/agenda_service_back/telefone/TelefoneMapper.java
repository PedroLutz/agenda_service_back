package com.agenda_service_back.telefone;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {
    @Mapping(source = "telefone_id", target = "telefone_id")
    TelefoneDTO toDTO(TelefoneEntity telefone);

    @Mapping(source = "telefoneDTO.telefone_id", target="telefone_id")
    TelefoneEntity toEntity(TelefoneDTO telefoneDTO);

    List<TelefoneDTO> toDTO(List<TelefoneEntity> telefones);
    @Mappings({
            @Mapping(source = "telefoneDTO.telefone_id", target = "telefone_id"),
            @Mapping(source = "telefoneDTO.telefone_numero", target = "telefone_numero"),
            @Mapping(source = "telefoneDTO.telefone_usuario_id", target = "telefone_usuario_id"),
            @Mapping(source = "telefoneDTO.telefone_prestador_id", target = "telefone_prestador_id"),
    })
    TelefoneEntity updateEntity(TelefoneDTO telefoneDTO, TelefoneEntity telefone);
}
