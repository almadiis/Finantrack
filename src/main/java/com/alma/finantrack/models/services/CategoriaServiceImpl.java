package com.alma.finantrack.models.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alma.finantrack.models.dao.ICategoriaDAO;
import com.alma.finantrack.models.dto.CategoriaDTO;
import com.alma.finantrack.models.entity.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private ICategoriaDAO categoriaRepository;

    @Override
    public List<CategoriaDTO> findAll() {
        List<Categoria> categorias = (List<Categoria>) categoriaRepository.findAll();
        return categorias.stream()
				.map(CategoriaDTO::fromEntity)
				.collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO findById(int id) {
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        return categoria != null ? CategoriaDTO.fromEntity(categoria) : null;
    }

    @Override
    public CategoriaDTO save(Categoria categoria) {
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return CategoriaDTO.fromEntity(savedCategoria);
    }

    @Override
    public void deleteById(int id) {
        categoriaRepository.deleteById(id);
    }
}
