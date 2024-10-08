package com.proyecto.ventas.service;

import java.util.List;

import com.proyecto.ventas.common.CommonSvc;
import com.proyecto.ventas.models.detalleVentasModel;

public interface detalleVentasService extends CommonSvc<detalleVentasModel> {
    List<detalleVentasModel> findByVentaId(Integer ventaId);
}