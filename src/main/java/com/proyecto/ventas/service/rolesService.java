package com.proyecto.ventas.service;

import java.util.Optional;

import com.proyecto.ventas.common.CommonSvc;
import com.proyecto.ventas.models.rolesModel;

public interface rolesService extends CommonSvc<rolesModel> {
    Optional<rolesModel> findByNombre(String nombre);
}
