package com.alma.finantrack.models.services;

import java.util.List;
import com.alma.finantrack.models.dto.PresupuestoDTO;
import com.alma.finantrack.models.entity.Presupuesto;

public interface PresupuestoService {
    List<PresupuestoDTO> findAll();
    PresupuestoDTO findById(int id);
    PresupuestoDTO save(Presupuesto presupuesto);
    void deleteById(int id);
}
