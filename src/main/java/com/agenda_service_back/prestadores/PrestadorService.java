package com.agenda_service_back.prestadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PrestadorService {
    @Autowired
    PrestadorRepository prestadorRepository;
    @Autowired
    PrestadorMapper prestadorMapper;

    public List<PrestadorDTO> findAll(){
        List<PrestadorEntity> prestadors = prestadorRepository.findAll();
        return prestadors.stream().map(prestadorMapper::toDTO).collect(Collectors.toList());
    }

    public PrestadorDTO findById(Long id){
        PrestadorEntity prestador = prestadorRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Prestador não encontrada"));
        return prestadorMapper.toDTO(prestador);
    }

    public PrestadorDTO create(PrestadorDTO prestadorDTO){
        PrestadorEntity prestador  = prestadorMapper.toEntity(prestadorDTO);
        prestador = prestadorRepository.save(prestador);
        return prestadorMapper.toDTO(prestador);
    }

    public PrestadorDTO update(Long id, PrestadorDTO prestadorDTO){
        PrestadorEntity prestador = prestadorRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Prestador não encontrada"));
        PrestadorEntity prestadorUpdate = prestadorMapper.updateEntity(prestadorDTO, prestador);
        prestadorUpdate = prestadorRepository.save(prestadorUpdate);
        return prestadorMapper.toDTO(prestadorUpdate);
    }

    public void deleteById(Long id){
        prestadorRepository.deleteById(id);
    }
}
