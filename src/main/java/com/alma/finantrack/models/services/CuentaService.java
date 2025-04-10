package com.alma.finantrack.models.services;


import java.util.List;

import com.alma.finantrack.models.dto.CuentaDTO;
import com.alma.finantrack.models.entity.Cuenta;

public interface CuentaService {
	List<CuentaDTO> findAll();
    CuentaDTO findById(int id);
    CuentaDTO save(Cuenta cuenta);
    void deleteById(int id);
}
