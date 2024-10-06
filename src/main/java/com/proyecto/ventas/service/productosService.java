package com.proyecto.ventas.service;

import java.util.Optional;

import com.proyecto.ventas.common.CommonSvc;
import com.proyecto.ventas.models.productosModel;

public interface productosService extends CommonSvc<productosModel>{
    public Iterable <productosModel> findAll();
    public Optional<productosModel> findById(int id);
    public productosModel save(productosModel entity);
    public void deleteById(int id);
    Iterable <productosModel> saveAll(Iterable<productosModel> entities);   
}
