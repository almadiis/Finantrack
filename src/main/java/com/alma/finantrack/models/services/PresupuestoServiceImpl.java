package com.alma.finantrack.models.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alma.finantrack.models.dao.IPresupuestoDAO;
import com.alma.finantrack.models.dto.PresupuestoDTO;
import com.alma.finantrack.models.entity.Presupuesto;

@Service
public class PresupuestoServiceImpl implements PresupuestoService {

    @Autowired
    private IPresupuestoDAO presupuestoRepository;

    @Override
    public List<PresupuestoDTO> findAll() {
        List<Presupuesto> presupuestos = (List<Presupuesto>) presupuestoRepository.findAll();
        return presupuestos.stream()
				.map(PresupuestoDTO::fromEntity)
				.collect(Collectors.toList());
    }

    @Override
    public PresupuestoDTO findById(int id) {
        Presupuesto presupuesto = presupuestoRepository.findById(id).orElse(null);
        return presupuesto != null ? PresupuestoDTO.fromEntity(presupuesto) : null;
    }

    @Override
    public PresupuestoDTO save(Presupuesto presupuesto) {
        Presupuesto savedPresupuesto = presupuestoRepository.save(presupuesto);
        return PresupuestoDTO.fromEntity(savedPresupuesto);
    }

    @Override
    public void deleteById(int id) {
        presupuestoRepository.deleteById(id);
    }
}
