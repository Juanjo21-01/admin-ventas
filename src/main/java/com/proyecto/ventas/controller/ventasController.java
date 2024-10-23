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

import com.proyecto.ventas.models.ventasModel;
import com.proyecto.ventas.service.ventasService;

@CrossOrigin
@RestController
@RequestMapping("ventas")
public class ventasController {
    @Autowired
    private ventasService ventasService;

    // Listar todas los ventas
    @GetMapping
    public Iterable<ventasModel> getVentas() {
        return this.ventasService.findAll();
    }

    // Listar por ID
    @GetMapping("/{idVenta}")
    public ResponseEntity<ventasModel> getVentaById(@PathVariable int idVenta) {
        Optional<ventasModel> venta = this.ventasService.findById(idVenta);

        if (venta.isPresent()) {
            return ResponseEntity.ok(venta.get());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Guardar una venta
    @PostMapping
    public ResponseEntity<?> saveVenta(@RequestBody ventasModel entity) {
        try {
            ventasService.save(entity);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar la venta");
        }
    }

    // Actualizar un estado de venta
    @PatchMapping("/cambiarEstado/{idVenta}")
    public ResponseEntity<String> updateVentaEstado(@PathVariable int idVenta, @RequestBody ventasModel entity) {
        try {
            ventasService.cambiarEstadoVenta(idVenta, entity.isEstado());
            return ResponseEntity.ok("Estado de la venta actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el estado de la venta");
        }
    }

    // Buscar por fecha de venta
    @GetMapping("/fecha/{fechaVenta}")
    public ResponseEntity<Iterable<ventasModel>> getVentasByFechaVenta(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaVenta) {

        System.out.println(fechaVenta);

        Iterable<ventasModel> ventas = this.ventasService.findByFechaVenta(fechaVenta);

        if (ventas.iterator().hasNext()) {
            return ResponseEntity.ok(ventas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<Iterable<ventasModel>> getVentasByEstado(@PathVariable Boolean estado) {
        Iterable<ventasModel> ventas = this.ventasService.findByEstado(estado);

        if (ventas.iterator().hasNext()) {
            return ResponseEntity.ok(ventas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por usuario
    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<Iterable<ventasModel>> getVentasByUsuarioId(@PathVariable Integer usuario) {
        Iterable<ventasModel> ventas = this.ventasService.findByUsuarioId(usuario);

        if (ventas.iterator().hasNext()) {
            return ResponseEntity.ok(ventas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
