package com.alma.finantrack.models.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alma.finantrack.models.dao.ITransaccionDAO;
import com.alma.finantrack.models.dto.TransaccionDTO;
import com.alma.finantrack.models.entity.Transaccion;

@Service
public class TransaccionServiceImpl implements TransaccionService {

	 @Autowired
    private ITransaccionDAO transaccionRepository;

    public List<TransaccionDTO> findAll() {
        List<Transaccion> transacciones = (List<Transaccion>) transaccionRepository.findAll();
        return transacciones.stream()
                .map(TransaccionDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public TransaccionDTO findById(int id) {
        Transaccion transaccion = transaccionRepository.findById(id).orElse(null);
        return transaccion != null ? TransaccionDTO.fromEntity(transaccion) : null;
    }

    public TransaccionDTO save(Transaccion transaccion) {
        Transaccion savedTransaccion = transaccionRepository.save(transaccion);
        return TransaccionDTO.fromEntity(savedTransaccion);
    }

    public void deleteById(int id) {
        transaccionRepository.deleteById(id);
    }
}
