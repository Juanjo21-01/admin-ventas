package com.proyecto.ventas.repository;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.ventas.models.productosModel;

public interface productosRepository extends CrudRepository<productosModel, Object> {
    
}
