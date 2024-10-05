package com.proyecto.ventas.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productos")


public class productosModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name="nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name="precio_unitario", nullable = false)
    private double precio_unitario;

    @Column(name="stock", nullable = false, length = 11)
    private int stock;

    @Column(name="estado", nullable = false, length = 1)
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "tipo_producto_id", nullable = false)
    private tipoProductosModel tipoProducto;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private proveedoresModel proveedor;

}
