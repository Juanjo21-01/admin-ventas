package com.proyecto.ventas.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.common.CommonSvcImpl;
import com.proyecto.ventas.models.detalleVentasModel;
import com.proyecto.ventas.repository.detalleVentasRepository;
import com.proyecto.ventas.service.detalleVentasService;

@Service
public class detalleVentasServiceImpl extends CommonSvcImpl<detalleVentasModel, detalleVentasRepository>
        implements detalleVentasService {

    // Buscar por venta
    @Override
    public List<detalleVentasModel> findByVentaId(Integer ventaId) {
        return this.repository.findByVentaId(ventaId);
    }
}
