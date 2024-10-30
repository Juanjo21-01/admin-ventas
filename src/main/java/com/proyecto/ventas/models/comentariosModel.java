package com.proyecto.ventas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "comentarios")
public class comentariosModel {
    @Id
    private String id;
    private String nombre_cliente;
    private String comentario;
    private LocalDateTime fecha_publicacion;
    private int usuarioId; // Nuevo campo para almacenar el ID del usuario
    private int productoId; // Nuevo campo para almacenar el ID del producto
    private int ventaId; // Nuevo compao para almancenar el ID de la venta
    private int detalleVentaId;

    public comentariosModel() {
        this.fecha_publicacion = LocalDateTime.now(); // Initialize fecha_publicacion
    }
    //Construcctor
    public comentariosModel(String id, String comentario, int usuarioId, int productoId, int ventaId, int detalleVentaId) {
        this.id = id;
        this.comentario = comentario;
        this.fecha_publicacion = LocalDateTime.now();
        this.usuarioId = usuarioId;
        this.productoId = productoId;
        this.ventaId = ventaId;
        this.detalleVentaId = detalleVentaId; 
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
     public String getNombre_cliente() {
        return nombre_cliente;
    }
    public  void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public LocalDateTime getFecha_publicacion() {
        return fecha_publicacion;
    }
    public void setFecha_publicacion(LocalDateTime fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
    public int getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    public int getProductoId() {
        return productoId;
    }
    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }
    public int getVentaId() {
        return ventaId;
    }
    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }
    public int getDetalleVentaId() {
        return detalleVentaId;
    }
    public void setDetalleVentaId(int detalleVentaId) {
        this.detalleVentaId = detalleVentaId;
    }
}
