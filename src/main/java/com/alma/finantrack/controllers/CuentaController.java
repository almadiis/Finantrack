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
import com.alma.finantrack.models.dto.CuentaDTO;
import com.alma.finantrack.models.entity.Cuenta;
import com.alma.finantrack.models.services.CuentaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    // Obtener todas las cuentas
    @GetMapping
    public List<CuentaDTO> getAllCuentas() {
        return cuentaService.findAll();
    }

    // Obtener una cuenta por ID
    @GetMapping("/{id}")
    public ResponseEntity<CuentaDTO> getCuentaById(@PathVariable int id) {
        CuentaDTO cuenta = cuentaService.findById(id);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cuenta);
    }

    // Crear una nueva cuenta
    @PostMapping
    public ResponseEntity<CuentaDTO> createCuenta(@RequestBody Cuenta cuenta) {
        CuentaDTO savedCuenta = cuentaService.save(cuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCuenta);
    }

    // Actualizar una cuenta existente
    @PutMapping("/{id}")
    public ResponseEntity<CuentaDTO> updateCuenta(@PathVariable int id, @RequestBody Cuenta cuenta) {
        CuentaDTO existingCuenta = cuentaService.findById(id);
        if (existingCuenta == null) {
            return ResponseEntity.notFound().build();
        }
        CuentaDTO updatedCuenta = cuentaService.save(cuenta);
        return ResponseEntity.ok(updatedCuenta);
    }

    // Eliminar una cuenta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable int id) {
        CuentaDTO cuenta = cuentaService.findById(id);
        if (cuenta == null) {
            return ResponseEntity.notFound().build();
        }
        cuentaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
