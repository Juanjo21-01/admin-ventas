package com.proyecto.ventas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ventas.models.detalleComprasModel;

@Repository
public interface detalleComprasRepository extends CrudRepository<detalleComprasModel, Object> {
    // Buscar por compra
    List<detalleComprasModel> findByCompraId(Integer compraId);
}