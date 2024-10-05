package com.proyecto.ventas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/roles")
public class rolesController {
    @Autowired
    private rolesService rolesService;
    
    @GetMapping("/listarRoles")
    public Iterable<rolesModel> getRoles() {
        return this.rolesService.findAll();
    }

    @PostMapping("/guardarRol")
    public ResponseEntity<String> saveClientes(@RequestBody rolesModel entity) {
        try {
            this.rolesService.save(entity);
            return ResponseEntity.ok("Rol guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }
    }
    @DeleteMapping("/eliminar/{idRol}")
    public ResponseEntity<String> deleteRol(@PathVariable int idRol) {
        try {
            this.rolesService.deleteById(idRol);
            return ResponseEntity.ok("Rol eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }
    }

      @PutMapping("/actualizar/{idRol}")
public ResponseEntity<String> updateRol(@PathVariable int idRol, @RequestBody rolesModel entity) {
    try {
      
        Optional<rolesModel> existingRol = this.rolesService.findById(idRol);
        
        if (existingRol.isPresent()) {
            rolesModel rolToUpdate = existingRol.get();
            
            rolToUpdate.setNombre(entity.getNombre());
            this.rolesService.save(rolToUpdate);
            return ResponseEntity.ok().body("Rol actualizado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
        }
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Error al actualizar el Rol");
    }
}
}
