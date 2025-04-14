package com.alma.finantrack.controllers;

import com.alma.finantrack.models.dto.TransaccionDTO;
import com.alma.finantrack.models.services.TransaccionService;
import com.alma.finantrack.models.entity.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    // Obtener todas las transacciones
    @GetMapping
    public List<TransaccionDTO> getAllTransacciones() {
        return transaccionService.findAll();
    }

    // Obtener una transacción por ID
    @GetMapping("/{id}")
    public ResponseEntity<TransaccionDTO> getTransaccionById(@PathVariable int id) {
        TransaccionDTO transaccion = transaccionService.findById(id);
        if (transaccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transaccion);
    }

    // Crear una nueva transacción
    @PostMapping
    public ResponseEntity<TransaccionDTO> createTransaccion(@RequestBody Transaccion transaccion) {
        TransaccionDTO savedTransaccion = transaccionService.save(transaccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransaccion);
    }

    // Actualizar una transacción existente
    @PutMapping("/{id}")
    public ResponseEntity<TransaccionDTO> updateTransaccion(@PathVariable int id, @RequestBody Transaccion transaccion) {
        TransaccionDTO existingTransaccion = transaccionService.findById(id);
        if (existingTransaccion == null) {
            return ResponseEntity.notFound().build();
        }
        transaccion.setId(id); // Asegurarse de que el ID de la transacción a actualizar sea correcto
        TransaccionDTO updatedTransaccion = transaccionService.save(transaccion);
        return ResponseEntity.ok(updatedTransaccion);
    }

    // Eliminar una transacción
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaccion(@PathVariable int id) {
        TransaccionDTO transaccion = transaccionService.findById(id);
        if (transaccion == null) {
            return ResponseEntity.notFound().build();
        }
        transaccionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
