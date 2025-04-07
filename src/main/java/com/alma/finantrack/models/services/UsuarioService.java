package com.alma.finantrack.models.services;

import com.alma.finantrack.models.entity.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
}
