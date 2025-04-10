package com.alma.finantrack.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alma.finantrack.models.dao.IPresupuestoDAO;
import com.alma.finantrack.models.entity.Presupuesto;

@Service
public class PresupuestoServiceImpl implements PresupuestoService {

    @Autowired
    private IPresupuestoDAO presupuestoRepository;

    @Override
    public List<Presupuesto> findAll() {
        return (List<Presupuesto>) presupuestoRepository.findAll();
    }

    @Override
    public Presupuesto findById(int id) {
        return presupuestoRepository.findById(id).orElse(null);
    }

    @Override
    public Presupuesto save(Presupuesto presupuesto) {
        return presupuestoRepository.save(presupuesto);
    }

    @Override
    public void deleteById(int id) {
        presupuestoRepository.deleteById(id);
    }
}
