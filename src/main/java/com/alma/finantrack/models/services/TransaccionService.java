package com.alma.finantrack.models.services;

import com.alma.finantrack.models.entity.Transaccion;
import java.util.List;

public interface TransaccionService {
    List<Transaccion> findAll();
    Transaccion findById(Long id);
    Transaccion save(Transaccion transaccion);
    void deleteById(Long id);
}
