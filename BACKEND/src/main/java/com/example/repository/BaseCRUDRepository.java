package com.example.repository;


import com.example.entity.Identifiable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseCRUDRepository<EntityType extends Identifiable> extends PrimaryRepository<Integer, EntityType> {
}


