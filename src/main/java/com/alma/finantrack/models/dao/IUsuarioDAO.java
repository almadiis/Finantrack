package com.alma.finantrack.models.dao;


import com.alma.finantrack.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByNombreAndPassword(String nombre, String password);

}
