package com.proyecto.ventas.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.ventas.common.CommonSvc;
import com.proyecto.ventas.models.usuariosModel;

public interface usuariosService extends CommonSvc<usuariosModel> {
    List<usuariosModel> findByNombres(String nombres);

    Optional<usuariosModel> findByEmail(String email);

    List<usuariosModel> findByEstado(Boolean estado);

    List<usuariosModel> findByRolId(Integer rolId);
}