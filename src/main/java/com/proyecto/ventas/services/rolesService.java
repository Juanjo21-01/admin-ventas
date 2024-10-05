package com.proyecto.ventas.services;

import java.util.Optional;

import com.proyecto.ventas.common.CommonSvc;
import com.proyecto.ventas.models.rolesModel;

public interface rolesService extends CommonSvc <rolesModel>{
    public Iterable <rolesModel> findAll();

    public Optional<rolesModel> findOptional(int id);

    public rolesModel save (rolesModel entity);

    public void deleteById(int id);

    Iterable<rolesModel> saveAll(Iterable<rolesModel> entities);

}
