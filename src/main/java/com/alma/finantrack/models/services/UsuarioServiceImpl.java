package com.alma.finantrack.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alma.finantrack.models.dao.IUsuarioDAO;
import com.alma.finantrack.models.dto.UsuarioDTO;
import com.alma.finantrack.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	 @Autowired
    private IUsuarioDAO usuarioRepository;

    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        return usuarios.stream()
                .map(UsuarioDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public UsuarioDTO findById(int id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return usuario != null ? UsuarioDTO.fromEntity(usuario) : null;
    }

    public UsuarioDTO save(Usuario usuario) {
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return UsuarioDTO.fromEntity(savedUsuario);
    }

    public void deleteById(int id) {
        usuarioRepository.deleteById(id);
    }

}
