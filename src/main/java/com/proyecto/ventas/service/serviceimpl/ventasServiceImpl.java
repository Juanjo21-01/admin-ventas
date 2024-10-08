package com.proyecto.ventas.service.serviceimpl;

import java.util.List;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.common.CommonSvcImpl;
import com.proyecto.ventas.models.ventasModel;
import com.proyecto.ventas.repository.ventasRepository;
import com.proyecto.ventas.service.ventasService;

@Service
public class ventasServiceImpl extends CommonSvcImpl<ventasModel, ventasRepository>
        implements ventasService {

    // Buscar por fecha de venta
    @Override
    public List<ventasModel> findByFechaVenta(Date fechaVenta) {
        return this.repository.findByFechaVenta(fechaVenta);
    }

    // Buscar todas los ventas con un estado
    @Override
    public List<ventasModel> findByEstado(Boolean estado) {
        return this.repository.findByEstado(estado);
    }

    // Buscar todas las ventas con el mismo usuario
    public List<ventasModel> findByUsuarioId(Integer usuarioId) {
        return this.repository.findByUsuarioId(usuarioId);
    }

    // Cambiar el estado de una venta
    public void cambiarEstadoVenta(Integer ventaId, Boolean estado) {
        ventasModel venta = this.repository.findById(ventaId).get();
        venta.setEstado(estado);
        this.repository.save(venta);
    }
}
