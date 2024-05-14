package com.agenda_service_back.agendamentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AgendamentoService {
    @Autowired
    AgendamentoRepository agendamentoRepository;
    @Autowired
    AgendamentoMapper agendamentoMapper;

    public List<AgendamentoDTO> findAll(){
        List<AgendamentoEntity> agendamentos = agendamentoRepository.findAll();
        return agendamentos.stream().map(agendamentoMapper::toDTO).collect(Collectors.toList());
    }

    public AgendamentoDTO findById(Long id){
        AgendamentoEntity agendamento = agendamentoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Agendamento não encontrada"));
        return agendamentoMapper.toDTO(agendamento);
    }

    public AgendamentoDTO create(AgendamentoDTO agendamentoDTO){
        AgendamentoEntity agendamento  = agendamentoMapper.toEntity(agendamentoDTO);
        agendamento = agendamentoRepository.save(agendamento);
        return agendamentoMapper.toDTO(agendamento);
    }

    public AgendamentoDTO update(Long id, AgendamentoDTO agendamentoDTO){
        AgendamentoEntity agendamento = agendamentoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Agendamento não encontrada"));
        AgendamentoEntity agendamentoUpdate = agendamentoMapper.updateEntity(agendamentoDTO, agendamento);
        agendamentoUpdate = agendamentoRepository.save(agendamentoUpdate);
        return agendamentoMapper.toDTO(agendamentoUpdate);
    }

    public void deleteById(Long id){
        agendamentoRepository.deleteById(id);
    }
}
