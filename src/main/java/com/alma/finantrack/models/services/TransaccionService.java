package com.alma.finantrack.models.services;

import java.util.List;

import com.alma.finantrack.models.dto.TransaccionDTO;
import com.alma.finantrack.models.entity.Transaccion;

public interface TransaccionService {
    List<TransaccionDTO> findAll();
    TransaccionDTO findById(int id);
    TransaccionDTO save(Transaccion transaccion);
    void deleteById(int id);
}
