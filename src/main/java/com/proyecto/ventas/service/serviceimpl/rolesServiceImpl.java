package com.proyecto.ventas.service.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.common.CommonSvcImpl;
import com.proyecto.ventas.models.rolesModel;
import com.proyecto.ventas.repository.rolesRepository;
import com.proyecto.ventas.service.rolesService;

@Service
public class rolesServiceImpl extends CommonSvcImpl<rolesModel, rolesRepository> implements rolesService {
    // Buscar por nombre
    @Override
    public Optional<rolesModel> findByNombre(String nombre) {
        return this.repository.findByNombre(nombre).stream().findFirst();
    }
}
