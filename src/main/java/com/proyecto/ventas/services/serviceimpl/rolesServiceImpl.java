package com.proyecto.ventas.services.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.common.CommonSvcImpl;
import com.proyecto.ventas.models.rolesModel;
import com.proyecto.ventas.repository.rolesRepository;
import com.proyecto.ventas.services.rolesService;

@Service
public class rolesServiceImpl extends CommonSvcImpl<rolesModel, rolesRepository> implements rolesService {

 
    @Override
    public void deleteById(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public Iterable<rolesModel> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<rolesModel> findById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public rolesModel save(rolesModel entity) {
        return this.repository.save(entity);
    }

    @Override
    public Iterable<rolesModel> saveAll(Iterable<rolesModel> entities) {
         return this.repository.saveAll(entities);
    }

    @Override /*No me dejo quitarlo */
    public Optional<rolesModel> findOptional(int id) {
        return Optional.empty();
    }

    
}
