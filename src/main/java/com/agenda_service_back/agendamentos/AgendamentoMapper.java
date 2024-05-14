package com.agenda_service_back.agendamentos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendamentoMapper {
    //Conversor Entity(Model) para DTO
    @Mapping(source = "agendamento_id", target = "agendamento_id")
    AgendamentoDTO toDTO(AgendamentoEntity agendamento);

    @Mapping(source = "agendamentoDTO.agendamento_id", target="agendamento_id")
    AgendamentoEntity toEntity(AgendamentoDTO agendamentoDTO);

    // recebendo uma lista de agendamentos do banco em DTO
    List<AgendamentoDTO> toDTO(List<AgendamentoEntity> agendamentos);
    //trocar os dados de AgendamentoDTO para Agendamento(entidade)
    @Mappings({
            @Mapping(source = "agendamentoDTO.agendamento_id", target = "agendamento_id"),
            @Mapping(source = "agendamentoDTO.agendamento_data", target = "agendamento_data"),
            @Mapping(source = "agendamentoDTO.agendamento_hora", target = "agendamento_hora"),
            @Mapping(source = "agendamentoDTO.agendamento_observacao", target = "agendamento_observacao"),
            @Mapping(source = "agendamentoDTO.agendamento_status", target = "agendamento_status"),
            @Mapping(source = "agendamentoDTO.agendamento_usuario_id", target = "agendamento_usuario_id"),
            @Mapping(source = "agendamentoDTO.agendamento_servico_id", target = "agendamento_servico_id"),
    })
    AgendamentoEntity updateEntity(AgendamentoDTO agendamentoDTO, AgendamentoEntity agendamento);
}