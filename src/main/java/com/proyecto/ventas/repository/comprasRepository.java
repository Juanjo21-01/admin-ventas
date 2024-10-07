package com.proyecto.ventas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ventas.models.comprasModel;

@Repository
public interface comprasRepository extends CrudRepository<comprasModel, Object> {
    // Buscar por fecha
    List<comprasModel> findByFechaCompra(Date fechaCompra);

    // Buscar por estado
    List<comprasModel> findByEstado(Boolean estado);

    // Buscar por proveedor
    List<comprasModel> findByProveedorId(Integer proveedorId);

    // Buscar por usuario
    List<comprasModel> findByUsuarioId(Integer usuarioId);
}