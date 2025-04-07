package com.alma.finantrack.models.dao;

import com.alma.finantrack.models.entity.Presupuesto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPresupuestoDAO extends CrudRepository<Presupuesto, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
