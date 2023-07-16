package com.medhead.medhead.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medhead.medhead.backend.model.Hospital;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long> {

	
	@Query("SELECT h FROM Hospital h WHERE ARRAY_CONTAINS(h.specializations,:specialisation) = true AND h.bedsAvailable >0")
    List<Hospital> getHospitalsBySpecialisationAndBedAvailable(@Param("specialisation") Integer specialisation);
    
}
