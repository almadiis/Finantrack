package com.alma.finantrack.models.services;

import com.alma.finantrack.models.entity.Presupuesto;
import java.util.List;

public interface PresupuestoService {
    List<Presupuesto> findAll();
    Presupuesto findById(Long id);
    Presupuesto save(Presupuesto presupuesto);
    void deleteById(Long id);
}
