package com.agenda_service_back.usuarios;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    //Conversor Entity(Model) para DTO
    @Mapping(source = "usuario_id", target = "usuario_id")
    UsuarioDTO toDTO(UsuarioEntity usuario);

    @Mapping(source = "usuarioDTO.usuario_id", target="usuario_id")
    UsuarioEntity toEntity(UsuarioDTO usuarioDTO);

    // recebendo uma lista de usuarios do banco em DTO
    List<UsuarioDTO> toDTO(List<UsuarioEntity> usuarios);
    //trocar os dados de UsuarioDTO para Usuario(entidade)
    @Mappings({
            @Mapping(source = "usuarioDTO.usuario_id", target = "usuario_id"),
            @Mapping(source = "usuarioDTO.usuario_nome", target = "usuario_nome"),
            @Mapping(source = "usuarioDTO.usuario_cpf", target = "usuario_cpf"),
            @Mapping(source = "usuarioDTO.usuario_email", target = "usuario_email"),
            @Mapping(source = "usuarioDTO.usuario_data_nascimento", target = "usuario_data_nascimento"),
            @Mapping(source = "usuarioDTO.usuario_senha", target = "usuario_senha"),
            @Mapping(source = "usuarioDTO.usuario_endereco_id", target = "usuario_endereco_id"),
    })
    UsuarioEntity updateEntity(UsuarioDTO usuarioDTO, UsuarioEntity usuario);

}