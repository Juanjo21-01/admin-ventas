package com.proyecto.ventas.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.common.CommonSvcImpl;
import com.proyecto.ventas.models.proveedoresModel;
import com.proyecto.ventas.repository.proveedoresRepository;
import com.proyecto.ventas.service.proveedoresService;

@Service
public class proveedoresServiceImpl extends CommonSvcImpl<proveedoresModel, proveedoresRepository>
        implements proveedoresService {

    // Buscar por nombre
    @Override
    public List<proveedoresModel> findByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }

    // Buscar por nit
    @Override
    public Optional<proveedoresModel> findByNit(String nit) {
        return this.repository.findByNit(nit).stream().findFirst();
    }

    // Buscar todos los proveedores con un estado
    @Override
    public List<proveedoresModel> findByEstado(Boolean estado) {
        return this.repository.findByEstado(estado);
    }
}
