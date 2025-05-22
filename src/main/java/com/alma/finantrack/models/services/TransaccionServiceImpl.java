package com.alma.finantrack.models.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alma.finantrack.models.dao.ITransaccionDAO;
import com.alma.finantrack.models.dto.TransaccionDTO;
import com.alma.finantrack.models.entity.Transaccion;
import com.alma.finantrack.models.dao.ICuentaDAO;
import com.alma.finantrack.models.dao.ICategoriaDAO;
import com.alma.finantrack.models.entity.Cuenta;
import com.alma.finantrack.models.entity.Categoria;
import java.sql.Date;
import java.util.Optional;


@Service
public class TransaccionServiceImpl implements TransaccionService {

	 @Autowired
    private ITransaccionDAO transaccionRepository;
	 @Autowired
	private ICuentaDAO cuentaRepository;
	 @Autowired
	private ICategoriaDAO categoriaRepository;

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

    @Override
    public TransaccionDTO save(Transaccion transaccion) {
        Transaccion saved = transaccionRepository.save(transaccion);
        return TransaccionDTO.fromEntity(saved);
    }

    public TransaccionDTO save(TransaccionDTO dto) {
        Optional<Cuenta> cuentaOpt = cuentaRepository.findById(dto.getId_cuenta());
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(dto.getId_categoria());

        if (cuentaOpt.isEmpty() || categoriaOpt.isEmpty()) {
            throw new RuntimeException("Cuenta o categoría no encontrada");
        }

        Transaccion entity = new Transaccion();
        entity.setId(dto.getId());
        entity.setMonto(dto.getMonto());
        entity.setFecha(Date.valueOf(dto.getFecha()));
        entity.setDescripcion(dto.getDescripcion());
        entity.setTipo(dto.getTipo());
        entity.setCuenta(cuentaOpt.get());
        entity.setCategoria(categoriaOpt.get());

        return TransaccionDTO.fromEntity(transaccionRepository.save(entity));
    }


    @Override
    public void deleteById(int id) {
        transaccionRepository.deleteById(id);
    }
}
