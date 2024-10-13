package com.proyecto.ventas.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class productoDTO {
    // Atributos
    private int id;
    private String nombre;
    private double precioUnitario;
    private int stock;
    private boolean estado;
    private String tipoProductoNombre;
    private String proveedorNombre;

    // Constructores
    public productoDTO() {
    }

    public productoDTO(int id, String nombre, double precioUnitario, int stock, boolean estado,
            String tipoProductoNombre,
            String proveedorNombre) {
        this.id = id;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.estado = estado;
        this.tipoProductoNombre = tipoProductoNombre;
        this.proveedorNombre = proveedorNombre;
    }
}
