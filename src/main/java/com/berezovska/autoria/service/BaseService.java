package com.berezovska.autoria.service;

import com.berezovska.autoria.model.BaseEntity;

import java.util.List;

public interface BaseService <T extends BaseEntity> {

    /**
     * Get all entities.
     * @return List<T> Entities list.
     **/
    List<T> getAll();

    /**
     * Get entity where id.
     * @param id Entity id.
     * @return T Entity object.
     **/
    T getById(int id);

    /**
     * Save Entity.
     * @param entity Entity object
     **/
    void save(T entity);
    void saveAll (List<T>entities);

    /**
     * Delete Entity where id.
     * @param id Entity id
     **/
    void delete(int id);

    /**
     * Update entity.
     * @param entity Entity object.
     * @return T Entity object.
     **/
    T update(T entity);


}
