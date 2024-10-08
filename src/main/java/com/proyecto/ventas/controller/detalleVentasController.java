package com.proyecto.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ventas.models.detalleVentasModel;
import com.proyecto.ventas.service.detalleVentasService;

@CrossOrigin
@RestController
@RequestMapping("detalle-ventas")
public class detalleVentasController {
    @Autowired
    private detalleVentasService detalleVentasService;

    // Listar por ventas
    @GetMapping("/{idVenta}")
    public Iterable<detalleVentasModel> getDetalleVentasByVenta(@PathVariable int idVenta) {
        return this.detalleVentasService.findByVentaId(idVenta);
    }

    // Guardar detalle de las ventas
    @PostMapping
    public ResponseEntity<String> saveVenta(@RequestBody detalleVentasModel entity) {
        try {
            detalleVentasService.save(entity);
            return ResponseEntity.ok("Detalle de la Venta no. " + entity.getVentaId() +
                    " guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar el detalle de la venta");
        }
    }
}
