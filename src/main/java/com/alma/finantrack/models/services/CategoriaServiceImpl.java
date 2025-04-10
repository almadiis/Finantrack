package com.alma.finantrack.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alma.finantrack.models.dao.ICategoriaDAO;
import com.alma.finantrack.models.entity.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private ICategoriaDAO categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findById(int id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void deleteById(int id) {
        categoriaRepository.deleteById(id);
    }
}
