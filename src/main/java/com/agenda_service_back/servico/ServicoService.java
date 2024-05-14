package com.agenda_service_back.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ServicoService {
    @Autowired
    ServicoRepository servicoRepository;
    @Autowired
    ServicoMapper servicoMapper;

    public List<ServicoDTO> findAll(){
        List<ServicoEntity> servicos = servicoRepository.findAll();
        return servicos.stream().map(servicoMapper::toDTO).collect(Collectors.toList());
    }

    public ServicoDTO findById(Long id){
        ServicoEntity servico = servicoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Servico não encontrada"));
        return servicoMapper.toDTO(servico);
    }

    public ServicoDTO create(ServicoDTO servicoDTO){
        ServicoEntity servico  = servicoMapper.toEntity(servicoDTO);
        servico = servicoRepository.save(servico);
        return servicoMapper.toDTO(servico);
    }

    public ServicoDTO update(Long id, ServicoDTO servicoDTO){
        ServicoEntity servico = servicoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Servico não encontrada"));
        ServicoEntity servicoUpdate = servicoMapper.updateEntity(servicoDTO, servico);
        servicoUpdate = servicoRepository.save(servicoUpdate);
        return servicoMapper.toDTO(servicoUpdate);
    }

    public void deleteById(Long id){
        servicoRepository.deleteById(id);
    }
}
