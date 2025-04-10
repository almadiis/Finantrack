package com.alma.finantrack.models.services;

import com.alma.finantrack.models.entity.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> findAll();
    Categoria findById(int id);
    Categoria save(Categoria categoria);
    void deleteById(int id);
}
