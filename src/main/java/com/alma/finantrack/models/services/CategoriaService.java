package com.alma.finantrack.models.services;

import java.util.List;
import com.alma.finantrack.models.dto.CategoriaDTO;
import com.alma.finantrack.models.entity.Categoria;

public interface CategoriaService {
    List<CategoriaDTO> findAll();
    CategoriaDTO findById(int id);
    CategoriaDTO save(Categoria categoria);
    void deleteById(int id);
}
