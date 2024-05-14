package com.agenda_service_back.telefone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TelefoneService {
    @Autowired
    TelefoneRepository telefoneRepository;
    @Autowired
    TelefoneMapper telefoneMapper;

    public List<TelefoneDTO> findAll(){
        List<TelefoneEntity> telefones = telefoneRepository.findAll();
        return telefones.stream().map(telefoneMapper::toDTO).collect(Collectors.toList());
    }

    public TelefoneDTO findById(Long id){
        TelefoneEntity telefone = telefoneRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Telefone não encontrada"));
        return telefoneMapper.toDTO(telefone);
    }

    public TelefoneDTO create(TelefoneDTO telefoneDTO){
        TelefoneEntity telefone  = telefoneMapper.toEntity(telefoneDTO);
        telefone = telefoneRepository.save(telefone);
        return telefoneMapper.toDTO(telefone);
    }

    public TelefoneDTO update(Long id, TelefoneDTO telefoneDTO){
        TelefoneEntity telefone = telefoneRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Telefone não encontrada"));
        TelefoneEntity telefoneUpdate = telefoneMapper.updateEntity(telefoneDTO, telefone);
        telefoneUpdate = telefoneRepository.save(telefoneUpdate);
        return telefoneMapper.toDTO(telefoneUpdate);
    }

    public void deleteById(Long id){
        telefoneRepository.deleteById(id);
    }
}
