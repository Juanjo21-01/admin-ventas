package com.proyecto.ventas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.proyecto.ventas.models.tipoProductosModel;
import com.proyecto.ventas.service.tipoProductosService;

@CrossOrigin
@RestController
@RequestMapping("tipo-productos")

public class tipoProductosController {
    @Autowired
    private tipoProductosService tipoProductosService;

    // Listar todos los tipos de productos
    @GetMapping
    public Iterable<tipoProductosModel> getTipoProductos() {
        return this.tipoProductosService.findAll();
    }

    // Listar por ID
    @GetMapping("/{idTipoProducto}")
    public ResponseEntity<tipoProductosModel> getTipoProductoById(@PathVariable int idTipoProducto) {
        Optional<tipoProductosModel> tipoProducto = this.tipoProductosService.findById(idTipoProducto);

        if (tipoProducto.isPresent()) {
            return ResponseEntity.ok(tipoProducto.get());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Guardar un tipo de producto
    @PostMapping
    public ResponseEntity<?> saveTipoProducto(@RequestBody tipoProductosModel entity) {
        try {
            this.tipoProductosService.save(entity);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar el tipo de producto");
        }
    }

    // Actualizar un tipo de producto
    @PutMapping("/{idTipoProducto}")
    public ResponseEntity<?> updateTipoProducto(@PathVariable int idTipoProducto,
            @RequestBody tipoProductosModel entity) {
        try {
            Optional<tipoProductosModel> tipoProducto = this.tipoProductosService.findById(idTipoProducto);

            if (tipoProducto.isPresent()) {
                entity.setId(idTipoProducto);
                this.tipoProductosService.save(entity);
                return ResponseEntity.ok(entity);
            } else {
                return ResponseEntity.badRequest().body("El tipo de producto no existe");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el tipo de producto");
        }
    }

    // Eliminar un tipo de producto
    @DeleteMapping("/{idTipoProducto}")
    public ResponseEntity<String> deleteTipoProducto(@PathVariable int idTipoProducto) {
        try {
            this.tipoProductosService.deleteById(idTipoProducto);
            return ResponseEntity.ok("Tipo de producto eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el tipo de producto");
        }
    }

    // Buscar por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Iterable<tipoProductosModel>> getTipoProductosByNombre(@PathVariable String nombre) {
        Iterable<tipoProductosModel> tipoProducto = this.tipoProductosService.findByNombre(nombre);

        if (tipoProducto.iterator().hasNext()) {
            return ResponseEntity.ok(tipoProducto);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Buscar por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<Iterable<tipoProductosModel>> getTipoProductosByEstado(@PathVariable Boolean estado) {
        Iterable<tipoProductosModel> tipoProducto = this.tipoProductosService.findByEstado(estado);

        if (tipoProducto.iterator().hasNext()) {
            return ResponseEntity.ok(tipoProducto);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
