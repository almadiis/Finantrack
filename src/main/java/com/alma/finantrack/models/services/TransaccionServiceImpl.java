package com.alma.finantrack.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alma.finantrack.models.dao.ITransaccionDAO;
import com.alma.finantrack.models.entity.Transaccion;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    private ITransaccionDAO transaccionRepository;

    @Override
    public List<Transaccion> findAll() {
        return (List<Transaccion>) transaccionRepository.findAll();
    }

    @Override
    public Transaccion findById(Long id) {
        return transaccionRepository.findById(id).orElse(null);
    }

    @Override
    public Transaccion save(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    @Override
    public void deleteById(Long id) {
        transaccionRepository.deleteById(id);
    }
}
