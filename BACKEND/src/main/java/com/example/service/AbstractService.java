package com.example.service;


import com.example.dao.AbstractDao;
import com.example.entity.Identifiable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T extends Identifiable> {

    protected abstract AbstractDao<T> getDao();


    public Page<T> get(Pageable pageable) {
        return getDao().get(pageable);
    }

    public Page<T> get(Specification<T> filter, Pageable pageable) {
        return getDao().get(filter, pageable, false);
    }

    public List<T> get(Specification<T> filter) {
        return getDao().get(filter);
    }

    public List<T> getAll() {return getDao().getAll();}

    public T getOne(Specification<T> filter) {
        return getDao().getOne(filter);
    }

    public Optional<T> getById(Integer id) {
        return getDao().getById(id);
    }

    public void delete(T entity) {
        getDao().delete(entity);
    }

    public void deleteById(Integer id) {
        getDao().deleteById(id);
    }

    public T save(T entity) {
        return getDao().create(entity);
    }

    public T update(T entity) throws IOException {
        return getDao().update(entity);
    }
    @Transactional
    public T update( T entity, boolean ignorePermissions ) {
        entity = getDao().update( entity, ignorePermissions );
        return entity;
    }
    @Transactional
    public void delete(Integer id, boolean ignorePermissions) {
        T entity = getDao().getById(id).get();
        delete(entity, ignorePermissions);
    }

    private void delete(T entity, boolean ignorePermissions) {
        beforeDelete(entity);
        getDao().delete(entity, ignorePermissions);
        afterDelete(entity);
    }

    protected void beforeDelete(T entity) {
    }

    protected void afterDelete(T entity) {
    }
}

