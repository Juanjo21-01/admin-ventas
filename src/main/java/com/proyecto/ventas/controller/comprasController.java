package com.proyecto.ventas.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ventas.models.comprasModel;
import com.proyecto.ventas.service.comprasService;

@CrossOrigin
@RestController
@RequestMapping("compras")
public class comprasController {
    @Autowired
    private comprasService comprasService;

    // Listar todas los compras
    @GetMapping
    public Iterable<comprasModel> getCompras() {
        return this.comprasService.findAll();
    }

    // Listar por ID
    @GetMapping("/{idCompra}")
    public ResponseEntity<comprasModel> getCompraById(@PathVariable int idCompra) {
        Optional<comprasModel> compra = this.comprasService.findById(idCompra);

        if (compra.isPresent()) {
            return ResponseEntity.ok(compra.get());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Guardar una compra
    @PostMapping
    public ResponseEntity<String> saveCompra(@RequestBody comprasModel entity) {
        try {
            comprasService.save(entity);
            return ResponseEntity.ok("Compra guardada correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar la compra");
        }
    }

    // Actualizar un estado de compra
    @PatchMapping("/cambiarEstado/{idCompra}")
    public ResponseEntity<String> updateCompraEstado(@PathVariable int idCompra, @RequestBody comprasModel entity) {
        try {
            comprasService.cambiarEstadoCompra(idCompra, entity.isEstado());
            return ResponseEntity.ok("Estado de la compra actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el estado de la compra");
        }
    }

    // Buscar por fecha de compra
    @GetMapping("/fecha/{fechaCompra}")
    public ResponseEntity<Iterable<comprasModel>> getComprasByFechaCompra(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCompra) {

        System.out.println(fechaCompra);

        Iterable<comprasModel> compras = this.comprasService.findByFechaCompra(fechaCompra);

        if (compras.iterator().hasNext()) {
            return ResponseEntity.ok(compras);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<Iterable<comprasModel>> getComprasByEstado(@PathVariable Boolean estado) {
        Iterable<comprasModel> compras = this.comprasService.findByEstado(estado);

        if (compras.iterator().hasNext()) {
            return ResponseEntity.ok(compras);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por proveedor
    @GetMapping("/proveedor/{proveedor}")
    public ResponseEntity<Iterable<comprasModel>> getComprasByProveedorId(@PathVariable Integer proveedor) {
        Iterable<comprasModel> compras = this.comprasService.findByProveedorId(proveedor);

        if (compras.iterator().hasNext()) {
            return ResponseEntity.ok(compras);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por usuario
    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<Iterable<comprasModel>> getComprasByUsuarioId(@PathVariable Integer usuario) {
        Iterable<comprasModel> compras = this.comprasService.findByUsuarioId(usuario);

        if (compras.iterator().hasNext()) {
            return ResponseEntity.ok(compras);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
