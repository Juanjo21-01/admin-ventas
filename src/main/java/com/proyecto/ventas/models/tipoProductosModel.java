package com.proyecto.ventas.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_productos")

public class tipoProductosModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name="nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name="estado", nullable = false, length = 1)
    private boolean estado;

    @OneToMany(mappedBy = "tipoProducto")
    private List<productosModel> productos;
}