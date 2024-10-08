package com.proyecto.ventas.service;

import java.util.List;
import java.util.Date;

import com.proyecto.ventas.common.CommonSvc;
import com.proyecto.ventas.models.comprasModel;

public interface comprasService extends CommonSvc<comprasModel> {
    List<comprasModel> findByFechaCompra(Date fechaCompra);

    List<comprasModel> findByEstado(Boolean estado);

    List<comprasModel> findByProveedorId(Integer proveedorId);

    List<comprasModel> findByUsuarioId(Integer usuarioId);

    void cambiarEstadoCompra(Integer compraId, Boolean estado);
}