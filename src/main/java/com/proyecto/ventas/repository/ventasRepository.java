package com.proyecto.ventas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ventas.models.ventasModel;

@Repository
public interface ventasRepository extends CrudRepository<ventasModel, Object> {
    // Buscar por fecha
    List<ventasModel> findByFecha(String fecha);

    // Buscar por estado
    List<ventasModel> findByEstado(Boolean estado);

    // Buscar por usuario
    List<ventasModel> findByUsuarioId(Integer usuarioId);
}