package com.proyecto.ventas.service;
import java.util.Optional;

import com.proyecto.ventas.common.CommonSvc;
import com.proyecto.ventas.models.proveedoresModel;

public interface proveedoresService extends CommonSvc<proveedoresModel> {
    public Iterable <proveedoresModel> findAll();
    public Optional<proveedoresModel> findById(int id);
    public proveedoresModel save(proveedoresModel entity);
    public void deleteById(int id);
    Iterable <proveedoresModel> saveAll(Iterable<proveedoresModel> entities);    
} 