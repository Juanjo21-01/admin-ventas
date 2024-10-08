package com.proyecto.ventas.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.common.CommonSvcImpl;
import com.proyecto.ventas.models.usuariosModel;
import com.proyecto.ventas.repository.usuariosRepository;
import com.proyecto.ventas.service.usuariosService;

@Service
public class usuariosServiceImpl extends CommonSvcImpl<usuariosModel, usuariosRepository>
        implements usuariosService {

    // Buscar por nombre
    @Override
    public List<usuariosModel> findByNombres(String nombres) {
        return this.repository.findByNombres(nombres);
    }

    // Buscar por email
    @Override
    public Optional<usuariosModel> findByEmail(String email) {
        return this.repository.findByEmail(email).stream().findFirst();
    }

    // Buscar todos los usuarios con un estado
    @Override
    public List<usuariosModel> findByEstado(Boolean estado) {
        return this.repository.findByEstado(estado);
    }

    // Buscar todos los usuarios con el mismo rol
    @Override
    public List<usuariosModel> findByRolId(Integer rolId) {
        return this.repository.findByRolId(rolId);
    }
}
