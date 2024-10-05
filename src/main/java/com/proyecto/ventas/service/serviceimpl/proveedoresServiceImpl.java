package com.proyecto.ventas.service.serviceimpl;

import com.proyecto.ventas.service.proveedoresService;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.common.commonSvcImpl;
import com.proyecto.ventas.models.proveedoresModel;
import com.proyecto.ventas.repository.proveedoresRepository;

@Service
public class proveedoresServiceImpl extends commonSvcImpl<proveedoresModel, proveedoresRepository> implements proveedoresService {

    @Override
    public void deleteById(int id) {
        this.repository.deleteById(id);
        
    }

    @Override
    public Iterable<proveedoresModel> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<proveedoresModel> findById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public proveedoresModel save(proveedoresModel entity) {
        return this.repository.save(entity);
    }

    @Override
    public Iterable<proveedoresModel> saveAll(Iterable<proveedoresModel> entities) {
        return this.repository.saveAll(entities);
    }
    
}
