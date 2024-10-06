package com.proyecto.ventas.common;

import java.util.Optional;

/**
 * Interface genérica para servicios comunes que proporciona operaciones CRUD
 * básicas.
 *
 * @param <E> El tipo de entidad manejada por este servicio.
 */
public interface CommonSvc<E> {

    /**
     * Recupera todos los elementos de la entidad.
     *
     * @return Un iterable de todas las entidades.
     */
    Iterable<E> findAll();

    /**
     * Busca una entidad por su ID.
     *
     * @param id El ID de la entidad a buscar.
     * @return Un Optional que puede contener la entidad encontrada o estar vacío si
     *         no se encontró.
     */
    Optional<E> findById(int id);

    /**
     * Guarda una nueva entidad.
     *
     * @param entity La entidad a guardar.
     * @return La entidad guardada.
     */
    E save(E entity);

    /**
     * Elimina una entidad por su ID.
     *
     * @param id El ID de la entidad a eliminar.
     */
    void deleteById(int id);

    /**
     * Guarda múltiples entidades.
     *
     * @param entities Un iterable de entidades a guardar.
     * @return Un iterable de entidades guardadas.
     */
    Iterable<E> saveAll(Iterable<E> entities);
}
