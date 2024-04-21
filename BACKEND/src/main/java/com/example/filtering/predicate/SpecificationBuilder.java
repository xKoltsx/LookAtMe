package com.example.filtering.predicate;


import com.example.filtering.searchcriteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<EntityType> {

    Specification<EntityType> buildSpecification(SearchCriteria searchCriteria);

}

