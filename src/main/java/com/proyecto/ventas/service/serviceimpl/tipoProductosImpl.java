package com.proyecto.ventas.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.common.CommonSvcImpl;
import com.proyecto.ventas.models.tipoProductosModel;
import com.proyecto.ventas.repository.tipoProductosRepository;
import com.proyecto.ventas.service.tipoProductosService;

@Service
public class tipoProductosImpl extends CommonSvcImpl<tipoProductosModel, tipoProductosRepository>
        implements tipoProductosService {

    // Buscar por nombre
    @Override
    public List<tipoProductosModel> findByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }

    // Buscar todos los tipo de productos con un estado
    @Override
    public List<tipoProductosModel> findByEstado(Boolean estado) {
        return this.repository.findByEstado(estado);
    }
}
