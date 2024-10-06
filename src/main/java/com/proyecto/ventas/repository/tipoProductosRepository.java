package com.proyecto.ventas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ventas.models.tipoProductosModel;

@Repository
public interface tipoProductosRepository extends CrudRepository<tipoProductosModel, Object> {
    // Buscar por nombre
    List<tipoProductosModel> findByNombre(String nombre);

    // Buscar por estado
    List<tipoProductosModel> findByEstado(Boolean estado);
}
