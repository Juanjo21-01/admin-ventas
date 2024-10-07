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

import com.proyecto.ventas.models.proveedoresModel;
import com.proyecto.ventas.service.proveedoresService;

@CrossOrigin
@RestController
@RequestMapping("proveedores")
public class proveedoresController {
    @Autowired
    private proveedoresService proveedoresService;

    // Listar todos los proveedores
    @GetMapping
    public Iterable<proveedoresModel> getProveedores() {
        return this.proveedoresService.findAll();
    }

    // Listar por ID
    @GetMapping("/{idProveedor}")
    public ResponseEntity<proveedoresModel> getProveedorById(@PathVariable int idProveedor) {
        Optional<proveedoresModel> proveedor = this.proveedoresService.findById(idProveedor);

        if (proveedor.isPresent()) {
            return ResponseEntity.ok(proveedor.get());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Guardar un proveedor
    @PostMapping
    public ResponseEntity<String> saveProveedor(@RequestBody proveedoresModel entity) {
        try {
            this.proveedoresService.save(entity);
            return ResponseEntity.ok("Proveedor guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar el proveedor");
        }
    }

    // Actualizar un proveedor
    @PutMapping("/{idProveedor}")
    public ResponseEntity<String> updateProveedor(@PathVariable int idProveedor,
            @RequestBody proveedoresModel entity) {
        try {
            Optional<proveedoresModel> proveedor = this.proveedoresService.findById(idProveedor);

            if (proveedor.isPresent()) {
                entity.setId(idProveedor);
                this.proveedoresService.save(entity);
                return ResponseEntity.ok("Proveedor actualizado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Proveedor no encontrado con ID: " + idProveedor);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el proveedor");
        }
    }

    // Eliminar un proveedor
    @DeleteMapping("/{idProveedor}")
    public ResponseEntity<String> deleteProveedor(@PathVariable int idProveedor) {
        try {
            this.proveedoresService.deleteById(idProveedor);
            return ResponseEntity.ok("Proveedor eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el proveedor con ID: " + idProveedor);
        }
    }

    // Buscar por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Iterable<proveedoresModel>> getProveedoresByNombre(@PathVariable String nombre) {
        Iterable<proveedoresModel> proveedores = this.proveedoresService.findByNombre(nombre);

        if (proveedores.iterator().hasNext()) {
            return ResponseEntity.ok(proveedores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por nit
    @GetMapping("/nit/{nit}")
    public ResponseEntity<proveedoresModel> getProveedorByNit(@PathVariable String nit) {
        Optional<proveedoresModel> proveedor = this.proveedoresService.findByNit(nit);

        if (proveedor.isPresent()) {
            return ResponseEntity.ok(proveedor.get());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Buscar por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<Iterable<proveedoresModel>> getProveedoresByEstado(@PathVariable Boolean estado) {
        Iterable<proveedoresModel> proveedores = this.proveedoresService.findByEstado(estado);

        if (proveedores.iterator().hasNext()) {
            return ResponseEntity.ok(proveedores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
