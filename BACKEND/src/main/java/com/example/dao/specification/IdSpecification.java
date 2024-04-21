package com.example.dao.specification;


import com.example.entity.PrimaryEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class IdSpecification<IdType, EntityType extends PrimaryEntity<IdType>>
        implements Specification<EntityType> {

    private static final long serialVersionUID = -3617213012291647979L;

    final IdType id;
    boolean inverse = false;

    public IdSpecification(IdType id) {
        this.id = id;
    }

    public IdSpecification(IdType id, boolean inverse) {
        this.id = id;
        this.inverse = inverse;
    }

    @Override
    public Specification<EntityType> and(Specification<EntityType> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<EntityType> or(Specification<EntityType> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<EntityType> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (!inverse) {
            return criteriaBuilder.equal(root.get("id"), (id));
        }
        return criteriaBuilder.notEqual(root.get("id"), (id));
    }
}
