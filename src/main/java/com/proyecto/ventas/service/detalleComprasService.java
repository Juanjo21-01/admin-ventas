package com.proyecto.ventas.service;

import java.util.List;

import com.proyecto.ventas.common.CommonSvc;
import com.proyecto.ventas.models.detalleComprasModel;

public interface detalleComprasService extends CommonSvc<detalleComprasModel> {
    List<detalleComprasModel> findByCompraId(Integer compraId);
}