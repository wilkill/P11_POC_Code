package com.medhead.medhead.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.medhead.medhead.backend.model.Hospital;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long> {

}
