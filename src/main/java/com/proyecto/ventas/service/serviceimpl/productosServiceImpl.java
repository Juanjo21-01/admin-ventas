package com.proyecto.ventas.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.common.CommonSvcImpl;
import com.proyecto.ventas.models.productosModel;
import com.proyecto.ventas.repository.productosRepository;
import com.proyecto.ventas.service.productosService;

@Service
public class productosServiceImpl extends CommonSvcImpl<productosModel, productosRepository>
        implements productosService {

    // Buscar por nombre
    @Override
    public List<productosModel> findByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }

    // Buscar todos los productos con un estado
    @Override
    public List<productosModel> findByEstado(Boolean estado) {
        return this.repository.findByEstado(estado);
    }

    // Buscar todos los productos con el mismo tipo de producto
    @Override
    public List<productosModel> findByTipoProductoId(Integer tipoProductoId) {
        return this.repository.findByTipoProductoId(tipoProductoId);
    }

    // Buscar todos los productos con el mismo proveedor
    @Override
    public List<productosModel> findByProveedorId(Integer proveedorId) {
        return this.repository.findByProveedorId(proveedorId);
    }
}
