package com.medhead.medhead.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.medhead.medhead.backend.model.Specialization;

@Repository
public interface SpecializationRepository extends CrudRepository<Specialization, Long> {

}
