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

@Table(name = "detalle_compras")
public class detalleComprasModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precio", nullable = false)
    private double precio;

    // Relación muchos a uno con la tabla Productos
    @JoinColumn(name = "producto_id", nullable = false)
    private Integer productoId;

    // Relación muchos a uno con la tabla Compras
    @JoinColumn(name = "compra_id", nullable = false)
    private Integer compraId;
}
