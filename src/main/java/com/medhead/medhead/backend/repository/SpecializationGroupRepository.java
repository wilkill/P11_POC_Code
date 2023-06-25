package com.medhead.medhead.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.medhead.medhead.backend.model.SpecializationGroup;

@Repository
public interface SpecializationGroupRepository extends CrudRepository<SpecializationGroup, Long> {

}
