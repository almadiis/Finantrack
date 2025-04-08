package com.alma.finantrack.controllers;

import com.alma.finantrack.models.entity.Presupuesto;
import com.alma.finantrack.models.services.PresupuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/presupuestos")
public class PresupuestoController {

    @Autowired
    private PresupuestoService presupuestoService;

    // Obtener todos los presupuestos
    @GetMapping
    public List<Presupuesto> getAllPresupuestos() {
        return presupuestoService.findAll();
    }

    // Obtener un presupuesto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Presupuesto> getPresupuestoById(@PathVariable Long id) {
        Presupuesto presupuesto = presupuestoService.findById(id);
        if (presupuesto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(presupuesto);
    }

    // Crear un nuevo presupuesto
    @PostMapping
    public ResponseEntity<Presupuesto> createPresupuesto(@RequestBody Presupuesto presupuesto) {
        Presupuesto savedPresupuesto = presupuestoService.save(presupuesto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPresupuesto);
    }

    // Actualizar un presupuesto existente
    @PutMapping("/{id}")
    public ResponseEntity<Presupuesto> updatePresupuesto(@PathVariable Long id, @RequestBody Presupuesto presupuesto) {
        Presupuesto existingPresupuesto = presupuestoService.findById(id);
        if (existingPresupuesto == null) {
            return ResponseEntity.notFound().build();
        }
        presupuesto.setId(id);
        Presupuesto updatedPresupuesto = presupuestoService.save(presupuesto);
        return ResponseEntity.ok(updatedPresupuesto);
    }

    // Eliminar un presupuesto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePresupuesto(@PathVariable Long id) {
        Presupuesto presupuesto = presupuestoService.findById(id);
        if (presupuesto == null) {
            return ResponseEntity.notFound().build();
        }
        presupuestoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
