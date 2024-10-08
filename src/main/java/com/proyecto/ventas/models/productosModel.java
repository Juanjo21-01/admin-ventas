package com.proyecto.ventas.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name = "productos")
public class productosModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    // Relacion de muchos a uno con la tabla tipo de productos
    @JoinColumn(name = "tipo_producto_id", nullable = false)
    private Integer tipoProductoId;

    // Relacion de muchos a uno con la tabla proveedores
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Integer proveedorId;
}
