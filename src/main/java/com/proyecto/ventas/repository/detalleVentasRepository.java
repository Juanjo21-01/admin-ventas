package com.proyecto.ventas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ventas.models.detalleVentasModel;

@Repository
public interface detalleVentasRepository extends CrudRepository<detalleVentasModel, Object> {
    // Buscar por ventas
    List<detalleVentasModel> findByVentaId(Integer ventaID);
}