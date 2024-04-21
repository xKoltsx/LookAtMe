package com.example.filtering.predicate;


import com.example.filtering.FilteringOperation;
import com.example.filtering.searchcriteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;

public class EqualOrContainSpecificationBuilder<EntityType> implements SpecificationBuilder<EntityType> {

    public static final List<FilteringOperation> SUPPORTED_OPERATORS = Arrays.asList(
            FilteringOperation.EQUAL, FilteringOperation.CONTAIN);

    @Override
    public Specification<EntityType> buildSpecification(SearchCriteria searchCriteria) {
        return new EqualOrContainSpecification<>(searchCriteria);
    }
}

