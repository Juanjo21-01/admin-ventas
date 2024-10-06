package com.proyecto.ventas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ventas.models.proveedoresModel;

@Repository
public interface proveedoresRepository extends CrudRepository<proveedoresModel, Object> {
    // Buscar por nombre
    List<proveedoresModel> findByNombre(String nombre);

    // Buscar por nit
    Optional<proveedoresModel> findByNit(String nit);

    // Buscar por estado
    List<proveedoresModel> findByEstado(Boolean estado);
}
