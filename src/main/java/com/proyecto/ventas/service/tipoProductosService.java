package com.proyecto.ventas.service;

import java.util.Optional;

import com.proyecto.ventas.common.CommonSvc;
import com.proyecto.ventas.models.tipoProductosModel;

public interface tipoProductosService extends CommonSvc<tipoProductosModel> {
    public Iterable <tipoProductosModel> findAll();
    public Optional<tipoProductosModel> findById(int id);
    public tipoProductosModel save(tipoProductosModel entity);
    public void deleteById(int id);
    Iterable <tipoProductosModel> saveAll(Iterable<tipoProductosModel> entities); 
}
