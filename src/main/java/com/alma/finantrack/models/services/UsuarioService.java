package com.alma.finantrack.models.services;

import java.util.List;

import com.alma.finantrack.models.dto.UsuarioDTO;
import com.alma.finantrack.models.entity.Usuario;

public interface UsuarioService {
    List<UsuarioDTO> findAll();
    UsuarioDTO findById(int id);
    UsuarioDTO save(Usuario usuario);
    void deleteById(int id);
}
