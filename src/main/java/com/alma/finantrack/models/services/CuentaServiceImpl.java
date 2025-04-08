package com.alma.finantrack.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alma.finantrack.models.dao.ICuentaDAO;
import com.alma.finantrack.models.entity.Cuenta;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private ICuentaDAO cuentaRepository;

    @Override
    public List<Cuenta> findAll() {
        return (List<Cuenta>) cuentaRepository.findAll();
    }

    @Override
    public Cuenta findById(Long id) {
        return cuentaRepository.findById(id).orElse(null);
    }

    @Override
    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void deleteById(Long id) {
        cuentaRepository.deleteById(id);
    }
}
