package com.proyecto.ventas.common;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.ventas.exceptions.CustomDatabaseException;

public class CommonSvcImpl<E, R extends CrudRepository<E, Object>> implements CommonSvc<E> {

    @Autowired
    protected R repository;

    @Override
    @Transactional
    public Iterable<E> findAll() {
        try {
            return repository.findAll();
        } catch (DataAccessException e) {
            throw new CustomDatabaseException("Error al obtener los registros", e);
        }
    }

    @Override
    @Transactional
    public Optional<E> findById(int id) {
        try {
            return repository.findById(id);
        } catch (DataAccessException e) {
            throw new CustomDatabaseException("Error al obtener el registro con el ID: " + id, e);
        }
    }

    @Override
    @Transactional
    public E save(E entity) {
        try {
            return repository.save(entity);
        } catch (DataAccessException e) {
            throw new CustomDatabaseException("Error al guardar el registro", e);
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        try {
            repository.deleteById(id);
        } catch (DataAccessException e) {
            throw new CustomDatabaseException("Error al eliminar el registro con el ID: " + id, e);
        }
    }

    @Override
    @Transactional
    public Iterable<E> saveAll(Iterable<E> entities) {
        try {
            return repository.saveAll(entities);
        } catch (DataAccessException e) {
            throw new CustomDatabaseException("Error al guardar los registros", e);
        }
    }

}