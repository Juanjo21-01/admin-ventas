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

import com.proyecto.ventas.models.usuariosModel;
import com.proyecto.ventas.service.usuariosService;

@CrossOrigin
@RestController
@RequestMapping("usuarios")
public class usuariosController {
    @Autowired
    private usuariosService usuariosService;

    // Listar todos los usuarios
    @GetMapping
    public Iterable<usuariosModel> getUsuarios() {
        return this.usuariosService.findAll();
    }

    // Listar por ID
    @GetMapping("/{idUsuario}")
    public ResponseEntity<usuariosModel> getUsuarioById(@PathVariable int idUsuario) {
        Optional<usuariosModel> usuario = this.usuariosService.findById(idUsuario);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Guardar un usuario
    @PostMapping
    public ResponseEntity<String> saveUsuario(@RequestBody usuariosModel entity) {
        try {
            this.usuariosService.save(entity);
            return ResponseEntity.ok("Usuario guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar el usuario");
        }
    }

    // Actualizar un usuario
    @PutMapping("/{idUsuario}")
    public ResponseEntity<String> updateUsuario(@PathVariable int idUsuario,
            @RequestBody usuariosModel entity) {
        try {
            Optional<usuariosModel> usuario = this.usuariosService.findById(idUsuario);

            if (usuario.isPresent()) {
                entity.setId(idUsuario);
                this.usuariosService.save(entity);
                return ResponseEntity.ok("Usuario actualizado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Usuario no encontrado con ID: " + idUsuario);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el usuario");
        }
    }

    // Eliminar un usuario
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<String> deleteUsuario(@PathVariable int idUsuario) {
        try {
            this.usuariosService.deleteById(idUsuario);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el usuario con ID: " + idUsuario);
        }
    }

    // Buscar por nombre
    @GetMapping("/nombres/{nombres}")
    public ResponseEntity<Iterable<usuariosModel>> getUsuariosByNombre(@PathVariable String nombres) {
        Iterable<usuariosModel> usuarios = this.usuariosService.findByNombres(nombres);

        if (usuarios.iterator().hasNext()) {
            return ResponseEntity.ok(usuarios);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por email
    @GetMapping("/email/{email}")
    public ResponseEntity<usuariosModel> getUsuariosByEmail(@PathVariable String email) {
        Optional<usuariosModel> usuarios = this.usuariosService.findByEmail(email);

        if (usuarios.isPresent()) {
            return ResponseEntity.ok(usuarios.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<Iterable<usuariosModel>> getUsuariosByEstado(@PathVariable Boolean estado) {
        Iterable<usuariosModel> usuarios = this.usuariosService.findByEstado(estado);

        if (usuarios.iterator().hasNext()) {
            return ResponseEntity.ok(usuarios);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por rol
    @GetMapping("/rol/{rolId}")
    public ResponseEntity<Iterable<usuariosModel>> getUsuariosByRolId(@PathVariable Integer rolId) {
        Iterable<usuariosModel> usuarios = this.usuariosService.findByRolId(rolId);

        if (usuarios.iterator().hasNext()) {
            return ResponseEntity.ok(usuarios);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
