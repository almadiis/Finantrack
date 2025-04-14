package com.alma.finantrack.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alma.finantrack.models.dto.PresupuestoDTO;
import com.alma.finantrack.models.entity.Presupuesto;
import com.alma.finantrack.models.services.PresupuestoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/presupuestos")
public class PresupuestoController {

    @Autowired
    private PresupuestoService presupuestoService;

    // Obtener todos los presupuestos
    @GetMapping
    public List<PresupuestoDTO> getAllPresupuestos() {
        return presupuestoService.findAll();
    }

    // Obtener un presupuesto por ID
    @GetMapping("/{id}")
    public ResponseEntity<PresupuestoDTO> getPresupuestoById(@PathVariable int id) {
        PresupuestoDTO presupuesto = presupuestoService.findById(id);
        if (presupuesto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(presupuesto);
    }

    // Crear un nuevo presupuesto
    @PostMapping
    public ResponseEntity<PresupuestoDTO> createPresupuesto(@RequestBody Presupuesto presupuesto) {
        PresupuestoDTO savedPresupuesto = presupuestoService.save(presupuesto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPresupuesto);
    }

    // Actualizar un presupuesto existente
    @PutMapping("/{id}")
    public ResponseEntity<PresupuestoDTO> updatePresupuesto(@PathVariable int id, @RequestBody Presupuesto presupuesto) {
        PresupuestoDTO existingPresupuesto = presupuestoService.findById(id);
        if (existingPresupuesto == null) {
            return ResponseEntity.notFound().build();
        }
        presupuesto.setId(id); // Asegúrate de que el ID del presupuesto a actualizar sea correcto
        PresupuestoDTO updatedPresupuesto = presupuestoService.save(presupuesto);
        return ResponseEntity.ok(updatedPresupuesto);
    }

    // Eliminar un presupuesto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePresupuesto(@PathVariable int id) {
        PresupuestoDTO presupuesto = presupuestoService.findById(id);
        if (presupuesto == null) {
            return ResponseEntity.notFound().build();
        }
        presupuestoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
