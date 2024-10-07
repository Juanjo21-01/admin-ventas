package com.proyecto.ventas.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.ventas.common.CommonSvc;
import com.proyecto.ventas.models.proveedoresModel;

public interface proveedoresService extends CommonSvc<proveedoresModel> {
    List<proveedoresModel> findByNombre(String nombre);

    Optional<proveedoresModel> findByNit(String nit);

    List<proveedoresModel> findByEstado(Boolean estado);
}