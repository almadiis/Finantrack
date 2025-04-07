package com.alma.finantrack.models.dao;

import com.alma.finantrack.models.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransaccionDAO extends JpaRepository<Transaccion, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
