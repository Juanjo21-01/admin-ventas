package com.proyecto.ventas.service;

import java.util.List;
import java.util.Date;

import com.proyecto.ventas.common.CommonSvc;
import com.proyecto.ventas.models.ventasModel;

public interface ventasService extends CommonSvc<ventasModel> {
    List<ventasModel> findByFechaVenta(Date fechaVenta);

    List<ventasModel> findByEstado(Boolean estado);

    List<ventasModel> findByUsuarioId(Integer usuarioId);

    void cambiarEstadoVenta(Integer ventaId, Boolean estado);
}