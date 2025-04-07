package com.alma.finantrack.controllers;

package com.alma.finantrack.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alma.finantrack.models.entity.Presupuesto;
import com.alma.finantrack.models.services.PresupuestoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class PresupuestoRestController {

    @Autowired
    private PresupuestoService presupuestoService;

    @GetMapping("/presupuestos")
    public List<Presupuesto> listar() {
        return presupuestoService.findAll();
    }

    @GetMapping("/presupuestos/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Presupuesto presupuesto = null;
        Map<String, Object> response = new HashMap<>();
        try {
            presupuesto = presupuestoService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (presupuesto == null) {
            response.put("mensaje", "El presupuesto ID: " + id + " no existe en la base de datos!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(presupuesto, HttpStatus.OK);
    }

    @PostMapping("/presupuestos")
    public ResponseEntity<?> crear(@RequestBody Presupuesto presupuesto) {
        Presupuesto presupuestoNuevo = null;
        Map<String, Object> response = new HashMap<>();
        try {
            presupuestoNuevo = presupuestoService.save(presupuesto);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El presupuesto ha sido creado con éxito!");
        response.put("presupuesto", presupuestoNuevo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/presupuestos/{id}")
    public ResponseEntity<?> update(@RequestBody Presupuesto presupuesto, @PathVariable Long id) {
        Presupuesto presupuestoActual = presupuestoService.findById(id);
        Map<String, Object> response = new HashMap<>();
        if (presupuestoActual == null) {
            response.put("mensaje", "Error: no se pudo editar, el presupuesto ID: " + id + " no existe en la base de datos!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try {
            presupuestoActual.setMontoMaximo(presupuesto.getMontoMaximo());
            presupuestoActual.setPeriodo(presupuesto.getPeriodo());
            presupuestoActual.setFechaInicio(presupuesto.getFechaInicio());
            presupuestoActual.setFechaFin(presupuesto.getFechaFin());
            presupuestoService.save(presupuestoActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el presupuesto en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El presupuesto ha sido actualizado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/presupuestos/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Presupuesto presupuesto = presupuestoService.findById(id);
        Map<String, Object> response = new HashMap<>();
        if (presupuesto == null) {
            response.put("mensaje", "Error: no se pudo borrar, el presupuesto ID: " + id + " no existe en la base de datos!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try {
            presupuestoService.deleteById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el presupuesto de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El presupuesto ha sido eliminado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
