package com.example.dao;


import com.example.dao.specification.IdSpecification;
import com.example.dao.specification.SpecificationUtil;
import com.example.entity.Archivable;
import com.example.entity.PrimaryEntity;
import com.example.filtering.ArchivedSpecification;
import com.example.repository.PrimaryRepository;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends PrimaryEntity<Integer>> {

    protected abstract PrimaryRepository<Integer, T> getRepository();

    public Page<T> get(Pageable pageable) {
        return get(pageable);
    }


    public Optional<T> getById(Integer id) {
        return getRepository().findById(id);
    }

    public List<T> getAll() {return (List<T>) getRepository().findAll();}


    public void delete(T entity) {
        if (entity instanceof Archivable) {
            ((Archivable) entity).setArchived(true);
            getRepository().save(entity);
        } else {
            delete(entity, false);
        }
    }

    public void delete(T entity, boolean ignorePermissions) {
        getRepository().deleteById(entity.getId());
    }


    public void deleteById(Integer id) {
        T entity = getById(id).orElseThrow();
        delete(entity, false);
    }

    public T create(T entity) {
        return getRepository().save(entity);
    }

    public T update(T entity) {
        return getRepository().save(entity);
    }

    public Page<T> get(Specification<T> filter, Pageable pageable) {
        return get(filter, pageable, false);
    }

    public Page<T> get(Specification<T> filter, Pageable pageable, boolean includeArchived) {
        Specification<T> specification = addSpecifications(includeArchived).and(filter).and(addAdditionalSpecificationsForGet());

        return getRepository().findAll(specification, pageable);
    }

    public List<T> get(Specification<T> filter) {
        return getRepository().findAll(filter);
    }

    protected Specification<T> addSpecifications() {
        return addSpecifications(false);
    }

    protected Specification<T> addSpecifications(boolean includeArchivedEntities) {
        Specification<T> specification = SpecificationUtil.initEmptySpec();

        if (!includeArchivedEntities && entityIsArchived()) {
            ArchivedSpecification<T> archivedSpecification = new ArchivedSpecification<>();
            specification = specification.and(archivedSpecification);
        }

        return specification;
    }

    protected Class<T>[] getEntityTypeClasses() {
        return (Class<T>[]) GenericTypeResolver.resolveTypeArguments(getClass(), AbstractDao.class);
    }

    private boolean entityIsArchived() {
        Class<T>[] entityTypeClasses = getEntityTypeClasses();
        return Archivable.class.isAssignableFrom(entityTypeClasses[0]);
    }

    protected Specification<T> addAdditionalSpecificationsForGet() {
        return null;
    }

    public T getOne(Specification<T> filter) {
        return getRepository().findOne(filter).orElseThrow();
    }

    public Page<T> get(Pageable pageable, boolean includeArchived) {
        Specification<T> specification = addSpecifications(includeArchived).and(addAdditionalSpecificationsForGet());
        Sort sort = pageable.getSort();
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

        return getRepository().findAll(specification, pageRequest);
    }

    public List<T> get(Sort sort, boolean includeArchived) {
        Specification<T> specification = addSpecifications(includeArchived).and(addAdditionalSpecificationsForGet());
        return getRepository().findAll(specification, sort);
    }

    public List<T> get(Specification<T> filter, Sort sort, boolean includeArchived) {
        Specification<T> specification = addSpecifications(includeArchived).and(filter).and(addAdditionalSpecificationsForGet());
        return getRepository().findAll(specification, sort);

    }

    public T update(T entity, boolean ignorePermissions) {
        return getRepository().save(entity);
    }

    public T getOneArchived(Integer id, boolean includeArchivedEntities) {
        return getOneArchived(id, includeArchivedEntities, null);
    }

    public T getOneArchived(Integer id, boolean includeArchivedEntities, Specification<T> additionalSpecification) {
        if (id == null) return null;
        Specification<T> mainSpecification = addSpecifications(includeArchivedEntities).and(new IdSpecification<>(id));

        if (additionalSpecification != null) {
            mainSpecification = additionalSpecification.and(mainSpecification);
        }

        return getRepository().findOne(mainSpecification).orElseThrow();
    }
}

