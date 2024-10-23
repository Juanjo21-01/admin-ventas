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

import com.proyecto.ventas.models.productosModel;
import com.proyecto.ventas.service.productosService;

@CrossOrigin
@RestController
@RequestMapping("productos")
public class productosController {
    @Autowired
    private productosService productosService;

    // Listar todos los productos
    @GetMapping
    public Iterable<productosModel> getProductos() {
        return this.productosService.findAll();
    }

    // Listar por ID
    @GetMapping("/{idProducto}")
    public ResponseEntity<productosModel> getProductoById(@PathVariable int idProducto) {
        Optional<productosModel> producto = this.productosService.findById(idProducto);

        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.get());
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Guardar un producto
    @PostMapping
    public ResponseEntity<?> saveProducto(@RequestBody productosModel entity) {
        try {
            productosService.save(entity);
            return ResponseEntity.ok(entity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar el producto");
        }
    }

    // Actualizar un producto
    @PutMapping("/{idProducto}")
    public ResponseEntity<?> updateProducto(@PathVariable int idProducto, @RequestBody productosModel entity) {
        try {
            Optional<productosModel> producto = this.productosService.findById(idProducto);

            if (producto.isPresent()) {
                entity.setId(idProducto);
                this.productosService.save(entity);
                return ResponseEntity.ok(entity);
            } else {
                return ResponseEntity.badRequest().body("Producto no encontrado con ID: " + idProducto);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el producto");
        }
    }

    // Eliminar un producto
    @DeleteMapping("/{idProducto}")
    public ResponseEntity<String> deleteProducto(@PathVariable int idProducto) {
        try {
            this.productosService.deleteById(idProducto);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el producto con ID: " + idProducto);
        }
    }

    // Buscar por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Iterable<productosModel>> getProductosByNombre(@PathVariable String nombre) {
        Iterable<productosModel> productos = this.productosService.findByNombre(nombre);

        if (productos.iterator().hasNext()) {
            return ResponseEntity.ok(productos);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<Iterable<productosModel>> getProductosByEstado(@PathVariable Boolean estado) {
        Iterable<productosModel> productos = this.productosService.findByEstado(estado);

        if (productos.iterator().hasNext()) {
            return ResponseEntity.ok(productos);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por tipo de producto
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<Iterable<productosModel>> getProductosByTipoId(@PathVariable Integer tipo) {
        Iterable<productosModel> productos = this.productosService.findByTipoProductoId(tipo);

        if (productos.iterator().hasNext()) {
            return ResponseEntity.ok(productos);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Buscar por proveedor
    @GetMapping("/proveedor/{proveedor}")
    public ResponseEntity<Iterable<productosModel>> getProductosByProveedorId(@PathVariable Integer proveedor) {
        Iterable<productosModel> productos = this.productosService.findByProveedorId(proveedor);

        if (productos.iterator().hasNext()) {
            return ResponseEntity.ok(productos);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
