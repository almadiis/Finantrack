package com.alma.finantrack.controllers;

import com.alma.finantrack.models.entity.Transaccion;
import com.alma.finantrack.models.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    // Obtener todas las transacciones
    @GetMapping
    public List<Transaccion> getAllTransacciones() {
        return transaccionService.findAll();
    }

    // Obtener una transacción por ID
    @GetMapping("/{id}")
    public ResponseEntity<Transaccion> getTransaccionById(@PathVariable Long id) {
        Transaccion transaccion = transaccionService.findById(id);
        if (transaccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transaccion);
    }

    // Crear una nueva transacción
    @PostMapping
    public ResponseEntity<Transaccion> createTransaccion(@RequestBody Transaccion transaccion) {
        Transaccion savedTransaccion = transaccionService.save(transaccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransaccion);
    }

    // Actualizar una transacción existente
    @PutMapping("/{id}")
    public ResponseEntity<Transaccion> updateTransaccion(@PathVariable Long id, @RequestBody Transaccion transaccion) {
        Transaccion existingTransaccion = transaccionService.findById(id);
        if (existingTransaccion == null) {
            return ResponseEntity.notFound().build();
        }
        transaccion.setId(id);
        Transaccion updatedTransaccion = transaccionService.save(transaccion);
        return ResponseEntity.ok(updatedTransaccion);
    }

    // Eliminar una transacción
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaccion(@PathVariable Long id) {
        Transaccion transaccion = transaccionService.findById(id);
        if (transaccion == null) {
            return ResponseEntity.notFound().build();
        }
        transaccionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
