package com.proyecto.ventas.service;

import java.util.List;

import com.proyecto.ventas.common.CommonSvc;
import com.proyecto.ventas.models.tipoProductosModel;

public interface tipoProductosService extends CommonSvc<tipoProductosModel> {
    List<tipoProductosModel> findByNombre(String nombre);

    List<tipoProductosModel> findByEstado(Boolean estado);
}
