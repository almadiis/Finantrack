package com.alma.finantrack.controllers;

import com.alma.finantrack.models.entity.Categoria;
import com.alma.finantrack.models.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.alma.finantrack.models.entity.Cuenta;
import com.alma.finantrack.models.services.CuentaService;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    // Obtener todas las cuentas
    @GetMapping
    public List<Cuenta> getAllCuentas() {
        return cuentaService.findAll();
    }

    // Obtener una cuenta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getCuentaById(@PathVariable Long id) {
        Cuenta cuenta = cuentaService.findById(id);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cuenta);
    }

    // Crear una nueva cuenta
    @PostMapping
    public ResponseEntity<Cuenta> createCuenta(@RequestBody Cuenta cuenta) {
        Cuenta savedCuenta = cuentaService.save(cuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCuenta);
    }

    // Actualizar una cuenta existente
    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        Cuenta existingCuenta = cuentaService.findById(id);
        if (existingCuenta == null) {
            return ResponseEntity.notFound().build();
        }
        cuenta.setId(id);
        Cuenta updatedCuenta = cuentaService.save(cuenta);
        return ResponseEntity.ok(updatedCuenta);
    }

    // Eliminar una cuenta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        Cuenta cuenta = cuentaService.findById(id);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }
        cuentaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
