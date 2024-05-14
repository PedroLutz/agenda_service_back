package com.agenda_service_back.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioMapper usuarioMapper;

    public List<UsuarioDTO> findAll(){
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuarioMapper::toDTO).collect(Collectors.toList());
    }

    public UsuarioDTO findById(Long id){
        UsuarioEntity usuario = usuarioRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Usuario não encontrada"));
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO create(UsuarioDTO usuarioDTO){
        UsuarioEntity usuario  = usuarioMapper.toEntity(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO){
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Usuario não encontrada"));
        UsuarioEntity usuarioUpdate = usuarioMapper.updateEntity(usuarioDTO, usuario);
        usuarioUpdate = usuarioRepository.save(usuarioUpdate);
        return usuarioMapper.toDTO(usuarioUpdate);
    }

    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }
}
