package com.alma.finantrack.models.dao;


import com.alma.finantrack.models.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICuentaDAO extends JpaRepository<Cuenta, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
