package com.alma.finantrack.controllers;

import com.alma.finantrack.models.entity.Usuario;
import com.alma.finantrack.models.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario existingUsuario = usuarioService.findById(id);
        if (existingUsuario == null) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);
        Usuario updatedUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
