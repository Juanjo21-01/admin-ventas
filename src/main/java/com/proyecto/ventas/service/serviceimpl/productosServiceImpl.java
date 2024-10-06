package com.proyecto.ventas.service.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.common.CommonSvcImpl;
import com.proyecto.ventas.models.productosModel;
import com.proyecto.ventas.repository.productosRepository;
import com.proyecto.ventas.service.productosService;

@Service
public class productosServiceImpl extends CommonSvcImpl<productosModel, productosRepository> implements productosService{

    @Override
    public void deleteById(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public Iterable<productosModel> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<productosModel> findById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public productosModel save(productosModel entity) {
        return this.repository.save(entity);
    }

    @Override
    public Iterable<productosModel> saveAll(Iterable<productosModel> entities) {
        return this.repository.saveAll(entities);
    }
    

}
