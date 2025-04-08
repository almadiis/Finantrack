package com.alma.finantrack.models.services;


import com.alma.finantrack.models.entity.Cuenta;
import java.util.List;

public interface CuentaService {
    List<Cuenta> findAll();
    Cuenta findById(Long id);
    Cuenta save(Cuenta cuenta);
    void deleteById(Long id);
}
