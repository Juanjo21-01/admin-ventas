package com.proyecto.ventas.controller;

import java.util.Optional;

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

import com.proyecto.ventas.models.rolesModel;
import com.proyecto.ventas.service.rolesService;

@CrossOrigin
@RestController
@RequestMapping("roles")
public class rolesController {
    @Autowired
    private rolesService rolesService;

    // Listar todos los roles
    @GetMapping
    public Iterable<rolesModel> getRoles() {
        return this.rolesService.findAll();
    }

    // Listar por ID
    @GetMapping("/{idRol}")
    public ResponseEntity<rolesModel> getRolById(@PathVariable int idRol) {
        Optional<rolesModel> rol = this.rolesService.findById(idRol);

        if (rol.isPresent()) {
            return ResponseEntity.ok(rol.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Guardar un rol
    @PostMapping
    public ResponseEntity<?> saveRole(@RequestBody rolesModel entity) {
        try {
            this.rolesService.save(entity);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar el rol");
        }
    }

    // Actualizar un rol
    @PutMapping("/{idRol}")
    public ResponseEntity<?> updateRol(@PathVariable int idRol, @RequestBody rolesModel entity) {
        try {
            Optional<rolesModel> rol = this.rolesService.findById(idRol);

            if (rol.isPresent()) {
                entity.setId(idRol);
                this.rolesService.save(entity);
                return ResponseEntity.ok(entity);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado con ID: " + idRol);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el rol");
        }
    }

    // Eliminar un rol
    @DeleteMapping("/{idRol}")
    public ResponseEntity<String> deleteRol(@PathVariable int idRol) {
        try {
            this.rolesService.deleteById(idRol);
            return ResponseEntity.ok("Rol eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el rol con ID: " + idRol);
        }
    }

    // Buscar por nombre
    @GetMapping("/nombre/{nombreRol}")
    public ResponseEntity<rolesModel> getRolByName(@PathVariable String nombreRol) {
        Optional<rolesModel> rol = this.rolesService.findByNombre(nombreRol);

        if (rol.isPresent()) {
            return ResponseEntity.ok(rol.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
