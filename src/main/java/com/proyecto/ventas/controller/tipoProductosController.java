package com.proyecto.ventas.controller;

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

@RestController
@RequestMapping("/tipo_productos")
@CrossOrigin

public class tipoProductosController {
    
    @Autowired
    private tipoProductosService tipoProductosService;

    @GetMapping("/listar")
    public Iterable<tipoProductosModel> getTipoProductos() {
        return this.tipoProductosService.findAll();
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> saveTipoProductos (@RequestBody tipoProductosModel entity) {
        try {
            this.tipoProductosService.save(entity);
            return ResponseEntity.ok("Tipo de producto guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }

    }

    @DeleteMapping("/eliminar/{idTipoProductos}")
    public ResponseEntity<String> deleteTipoProductos (@PathVariable int idTipoProductos) {
        try {
            this.tipoProductosService.deleteById(idTipoProductos);
            return ResponseEntity.ok("Tipo de producto eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }

    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> updateTipoProductos (@RequestBody tipoProductosModel entity) {
        try {
            this.tipoProductosService.save(entity);
            return ResponseEntity.ok("Tipo de producto actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }
    }
}
