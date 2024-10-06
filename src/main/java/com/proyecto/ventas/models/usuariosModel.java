package com.proyecto.ventas.models;

import java.io.Serializable;
import java.util.List;

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

@Table(name = "usuarios")
public class usuariosModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "telefono", nullable = false, length = 8)
    private String telefono;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    // Relacion de muchos a uno con la tabla Roles
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id", nullable = false)
    private rolesModel rol;

    // Relacion de uno a muchos con la tabla Compras
    @OneToMany(mappedBy = "usuario")
    private List<comprasModel> compras;

    // Relacion de uno a muchos con la tabla Ventas
    @OneToMany(mappedBy = "usuario")
    private List<ventasModel> ventas;
}
