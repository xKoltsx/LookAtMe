package com.example.repository;


import com.example.entity.PrimaryEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface PrimaryRepository<IdType, EntityType extends PrimaryEntity<IdType>> extends CrudRepository<EntityType, IdType>,
        JpaSpecificationExecutor<EntityType>, PagingAndSortingRepository<EntityType, IdType> {

}
