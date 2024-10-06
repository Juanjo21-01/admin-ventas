package com.proyecto.ventas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ventas.models.usuariosModel;

@Repository
public interface usuariosRepository extends CrudRepository<usuariosModel, Object> {
    // Buscar por nombre
    List<usuariosModel> findByNombres(String nombres);

    // Buscar por email
    Optional<usuariosModel> findByEmail(String email);

    // Buscar por estado
    List<usuariosModel> findByEstado(Boolean estado);

    // Buscar por rol
    List<usuariosModel> findByRolId(Integer rolId);
}