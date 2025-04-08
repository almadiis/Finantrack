package com.alma.finantrack.controllers;

import com.alma.finantrack.models.entity.Categoria;
import com.alma.finantrack.models.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Obtener todas las categorías
    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.findAll();
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        Categoria categoria = categoriaService.findById(id);
        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoria);
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        Categoria savedCategoria = categoriaService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoria);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria existingCategoria = categoriaService.findById(id);
        if (existingCategoria == null) {
            return ResponseEntity.notFound().build();
        }
        categoria.setId(id);
        Categoria updatedCategoria = categoriaService.save(categoria);
        return ResponseEntity.ok(updatedCategoria);
    }

    // Eliminar una categoría
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        Categoria categoria = categoriaService.findById(id);
        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
