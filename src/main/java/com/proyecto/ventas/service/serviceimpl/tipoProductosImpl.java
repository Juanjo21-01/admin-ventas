package com.proyecto.ventas.service.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.common.CommonSvcImpl;
import com.proyecto.ventas.models.tipoProductosModel;
import com.proyecto.ventas.repository.tipoProductosRepository;
import com.proyecto.ventas.service.tipoProductosService;

@Service
public class tipoProductosImpl extends CommonSvcImpl<tipoProductosModel, tipoProductosRepository> implements tipoProductosService {

    @Override
    public void deleteById(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public Iterable<tipoProductosModel> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<tipoProductosModel> findById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public tipoProductosModel save(tipoProductosModel entity) {
        return this.repository.save(entity);
    }
    

    @Override
    public Iterable<tipoProductosModel> saveAll(Iterable<tipoProductosModel> entities) {
        return this.repository.saveAll(entities);
    }
    

}
