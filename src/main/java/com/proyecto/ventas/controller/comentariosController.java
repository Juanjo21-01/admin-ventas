package com.proyecto.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.ventas.models.*;
import com.proyecto.ventas.repository.*;

import java.util.List;
//import java.util.Optional;

@RestController
@RequestMapping("/comentarios")
public class comentariosController {

    @Autowired
    private comentariosRepository comentariosRepository; 

    @Autowired
    private usuariosRepository usuariosRepository; 

    @Autowired
    private productosRepository productosRepository; 

    @Autowired
    private ventasRepository ventasRepository; 

    @Autowired
    private detalleVentasRepository detalleVentasRepository; 

    @GetMapping
    public ResponseEntity<List<comentariosModel>> getComentarios() {
        List<comentariosModel> comentarios = comentariosRepository.findAll();
        return ResponseEntity.ok(comentarios);
    }
     @PostMapping
    public ResponseEntity<String> saveComentario(
            @RequestBody comentariosModel entity,
            @RequestParam int usuarioId,
            @RequestParam int productoId) {
        
        // Verificar que el usuario existe y tiene el rol adecuado
        usuariosModel usuario = usuariosRepository.findById(usuarioId)
            .orElse(null);
        
        // Verificar si el usuario existe
        if (usuario == null) {
            return ResponseEntity.badRequest()
                .body("Usuario no encontrado");
        }
        
        // Verificar si el usuario tiene el rol correcto (rol cliente = 1)
        if (!usuario.getRolId().equals(1)) {
            return ResponseEntity.badRequest()
                .body("El usuario no tiene permisos para comentar");
        }
        
        // Verificar que el producto existe
        productosModel producto = productosRepository.findById(productoId)
            .orElse(null);
            
        if (producto == null) {
            return ResponseEntity.badRequest()
                .body("El producto no existe");
        }
        boolean haCompradoProducto = false;
        Integer ventaId = null;
        Integer detalleVentaId = null;

            // Obtener todas las ventas del usuario
        List<ventasModel> ventasUsuario = ventasRepository.findByUsuarioId(usuarioId);

        for (ventasModel venta : ventasUsuario) {
            List<detalleVentasModel> detalles = detalleVentasRepository.findByVentaId(venta.getId());
            
            for (detalleVentasModel detalle : detalles) {
                if (detalle.getProductoId().equals(productoId)) {
                    haCompradoProducto = true;
                    ventaId = venta.getId();
                    detalleVentaId = detalle.getId();
                    break;
                }
            }
            
            if (haCompradoProducto) {
                break;
            }
        }
        if (!haCompradoProducto) {
            return ResponseEntity.badRequest()
                .body("Solo puedes comentar productos que hayas comprado");
        }
       // 5. Configurar el comentario con el nombre completo del usuario
       String nombreCompleto = usuario.getNombres() + " " + usuario.getApellidos();
       entity.setNombre_cliente(nombreCompleto);
       entity.setUsuarioId(usuarioId);
       entity.setProductoId(productoId);
       entity.setVentaId(ventaId);
       entity.setDetalleVentaId(detalleVentaId);
        
        // Guardar el comentario
        comentariosRepository.save(entity);
        
        return ResponseEntity.ok("Comentario guardado correctamente");
    }
} 


