package com.proyecto.ventas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ventas.models.rolesModel;

@Repository
public interface rolesRepository extends CrudRepository<rolesModel, Object> {
    // Buscar por nombre
    List<rolesModel> findByNombre(String nombre);
}
