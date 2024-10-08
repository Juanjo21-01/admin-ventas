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

import com.proyecto.ventas.models.detalleComprasModel;
import com.proyecto.ventas.service.detalleComprasService;

@CrossOrigin
@RestController
@RequestMapping("detalle-compras")
public class detalleComprasController {
    @Autowired
    private detalleComprasService detalleComprasService;

    // Listar por compras
    @GetMapping("/{idCompra}")
    public Iterable<detalleComprasModel> getDetalleComprasByCompra(@PathVariable int idCompra) {
        return this.detalleComprasService.findByCompraId(idCompra);
    }

    // Guardar detalle de las compras
    @PostMapping
    public ResponseEntity<String> saveCompra(@RequestBody detalleComprasModel entity) {
        try {
            detalleComprasService.save(entity);
            return ResponseEntity.ok("Detalle de la Compra no. " + entity.getCompraId() +
                    " guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar el detalle de la compra");
        }
    }
}
