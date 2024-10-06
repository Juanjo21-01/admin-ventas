package com.proyecto.ventas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ventas.models.productosModel;

@Repository
public interface productosRepository extends CrudRepository<productosModel, Object> {
    // Buscar por nombre
    List<productosModel> findByNombre(String nombre);

    // Buscar por estado
    List<productosModel> findByEstado(Boolean estado);

    // Buscar por tipo de producto
    List<productosModel> findByTipoProductoId(Integer tipoProductoId);

    // Buscar por proveedor
    List<productosModel> findByProveedorId(Integer proveedorId);
}