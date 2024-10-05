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

import com.proyecto.ventas.models.proveedoresModel;
import com.proyecto.ventas.service.proveedoresService;

@RestController
@RequestMapping
@CrossOrigin


public class proveedoresController {

    @Autowired
    private proveedoresService proveedoresService;

     @GetMapping("/listar")
    public Iterable<proveedoresModel> getProveedores() {
        return this.proveedoresService.findAll();
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> saveProveedores(@RequestBody proveedoresModel entity) {
        try {
            this.proveedoresService.save(entity);
            return ResponseEntity.ok("Proveedor guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }

    }

    @DeleteMapping("/eliminar/{idProveedor}")
    public ResponseEntity<String> deleteProveedores(@PathVariable int idCliente) {
        try {
            this.proveedoresService.deleteById(idCliente);
            return ResponseEntity.ok("Proveedor eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }

    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> updateProveedores(@RequestBody proveedoresModel entity) {
        try {
            this.proveedoresService.save(entity);
            return ResponseEntity.ok("Proveedor actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el servidor");
        }

    }
}
