package com.proyecto.ventas.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name = "ventas")
public class ventasModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_venta", nullable = false)
    private Date fechaVenta;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @Column(name = "observaciones", length = 200)
    private String observaciones;

    // Relación uno a muchos con la tabla Usuarios
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private usuariosModel usuario;

    // Relación uno a muchos con la tabla Detalle de ventas
    @JsonIgnore
    @OneToMany(mappedBy = "venta")
    private List<detalleVentasModel> detalleVentas;
}
