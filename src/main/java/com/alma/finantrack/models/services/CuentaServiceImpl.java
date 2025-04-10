package com.alma.finantrack.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alma.finantrack.models.dao.ICuentaDAO;
import com.alma.finantrack.models.dto.CuentaDTO;
import com.alma.finantrack.models.entity.Cuenta;

@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
    private ICuentaDAO cuentaRepository;

    @Override
    public List<CuentaDTO> findAll() {
        List<Cuenta> cuentas = (List<Cuenta>) cuentaRepository.findAll();
        return cuentas.stream()
                .map(CuentaDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CuentaDTO findById(int id) {
        Cuenta cuenta = cuentaRepository.findById(id).orElse(null);
        return cuenta != null ? CuentaDTO.fromEntity(cuenta) : null;
    }

    @Override
    public CuentaDTO save(Cuenta cuenta) {
        Cuenta savedCuenta = cuentaRepository.save(cuenta);
        return CuentaDTO.fromEntity(savedCuenta);
    }

    @Override
    public void deleteById(int id) {
        cuentaRepository.deleteById(id);
    }
}
