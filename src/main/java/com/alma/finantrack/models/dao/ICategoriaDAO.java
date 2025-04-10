package com.alma.finantrack.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alma.finantrack.models.entity.Categoria;

@Repository
public interface ICategoriaDAO extends JpaRepository<Categoria, Integer> {
}
