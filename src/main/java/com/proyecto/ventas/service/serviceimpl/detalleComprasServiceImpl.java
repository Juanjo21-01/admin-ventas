package com.proyecto.ventas.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.common.CommonSvcImpl;
import com.proyecto.ventas.models.detalleComprasModel;
import com.proyecto.ventas.repository.detalleComprasRepository;
import com.proyecto.ventas.service.detalleComprasService;

@Service
public class detalleComprasServiceImpl extends CommonSvcImpl<detalleComprasModel, detalleComprasRepository>
        implements detalleComprasService {

    // Buscar por compra
    @Override
    public List<detalleComprasModel> findByCompraId(Integer compraId) {
        return this.repository.findByCompraId(compraId);
    }
}
