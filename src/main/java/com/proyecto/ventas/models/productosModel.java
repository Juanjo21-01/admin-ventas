package com.proyecto.ventas.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_producto_id", nullable = false)
    private tipoProductosModel tipoProducto;

    // Relacion de muchos a uno con la tabla proveedores
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_id", nullable = false)
    private proveedoresModel proveedor;

    // Relacion de uno a muchos con la tabla detalle de compras
    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<detalleComprasModel> detalleCompras;

    // Relacion de uno a muchos con la tabla detalle de ventas
    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<detalleVentasModel> detalleVentas;
}
