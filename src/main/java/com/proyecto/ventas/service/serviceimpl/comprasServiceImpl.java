package com.proyecto.ventas.service.serviceimpl;

import java.util.List;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.common.CommonSvcImpl;
import com.proyecto.ventas.models.comprasModel;
import com.proyecto.ventas.repository.comprasRepository;
import com.proyecto.ventas.service.comprasService;

@Service
public class comprasServiceImpl extends CommonSvcImpl<comprasModel, comprasRepository>
        implements comprasService {

    // Buscar por fecha de compra
    @Override
    public List<comprasModel> findByFechaCompra(Date fechaCompra) {
        return this.repository.findByFechaCompra(fechaCompra);
    }

    // Buscar todas los compras con un estado
    @Override
    public List<comprasModel> findByEstado(Boolean estado) {
        return this.repository.findByEstado(estado);
    }

    // Buscar todas las compras con el mismo proveedor
    @Override
    public List<comprasModel> findByProveedorId(Integer proveedorId) {
        return this.repository.findByProveedorId(proveedorId);
    }

    // Buscar todas las compras con el mismo usuario
    public List<comprasModel> findByUsuarioId(Integer usuarioId) {
        return this.repository.findByUsuarioId(usuarioId);
    }

    // Cambiar el estado de una compra
    public void cambiarEstadoCompra(Integer compraId, Boolean estado) {
        comprasModel compra = this.repository.findById(compraId).get();
        compra.setEstado(estado);
        this.repository.save(compra);
    }
}
