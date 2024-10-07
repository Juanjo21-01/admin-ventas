package com.proyecto.ventas.service;

import java.util.List;

import com.proyecto.ventas.common.CommonSvc;
import com.proyecto.ventas.models.productosModel;

public interface productosService extends CommonSvc<productosModel> {
    List<productosModel> findByNombre(String nombre);

    List<productosModel> findByEstado(Boolean estado);

    List<productosModel> findByTipoProductoId(Integer tipoProductoId);

    List<productosModel> findByProveedorId(Integer proveedorId);
}
