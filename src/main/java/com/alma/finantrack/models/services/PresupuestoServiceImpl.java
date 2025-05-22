package com.alma.finantrack.models.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alma.finantrack.models.dao.IPresupuestoDAO;
import com.alma.finantrack.models.dto.PresupuestoDTO;
import com.alma.finantrack.models.entity.Presupuesto;
import com.alma.finantrack.models.dao.ICategoriaDAO;
import com.alma.finantrack.models.dao.IUsuarioDAO;
import java.sql.Date;

@Service
public class PresupuestoServiceImpl implements PresupuestoService {

    @Autowired
    private IPresupuestoDAO presupuestoRepository;
    @Autowired
    private ICategoriaDAO categoriaRepository;
    @Autowired
    private IUsuarioDAO usuarioRepository;

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
    public PresupuestoDTO save(PresupuestoDTO dto) {
        Presupuesto entity = new Presupuesto();
        entity.setId(dto.getId());
        entity.setMontoMaximo(dto.getMontoMaximo());
        entity.setPeriodo(dto.getPeriodo());

        try {
            entity.setFechaInicio(Date.valueOf(dto.getFechaInicio()));
            entity.setFechaFin(Date.valueOf(dto.getFechaFin()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Formato de fecha incorrecto. Esperado yyyy-MM-dd", e);
        }

        entity.setCategoria(categoriaRepository.findById(dto.getCategoria())
            .orElseThrow(() -> new RuntimeException("Categoría no encontrada")));
        entity.setUsuario(usuarioRepository.findById(dto.getId_usuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        Presupuesto saved = presupuestoRepository.save(entity);
        return PresupuestoDTO.fromEntity(saved);
    }

    @Override
    public void deleteById(int id) {
        presupuestoRepository.deleteById(id);
    }
}
