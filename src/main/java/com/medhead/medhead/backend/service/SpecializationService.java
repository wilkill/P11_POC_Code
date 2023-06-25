package com.medhead.medhead.backend.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medhead.medhead.backend.model.Specialization;
import com.medhead.medhead.backend.repository.SpecializationRepository;
import com.medhead.medhead.backend.tool.CommonTools;
import com.medhead.medhead.backend.tool.LoggerTools;

import lombok.Data;

@Data
@Service
public class SpecializationService {
	
	/**
	 * Tag for the logs
	 */
	private final String _className = CommonTools.INSTANCE.getClassName(SpecializationService.class);
	
    @Autowired
    private SpecializationRepository specializationRepository;

    public Optional<Specialization> getSpecialization(final Long id) {
    	LoggerTools.INSTANCE.logInfo(_className, "Call getSpecialization id["+id+"]");
        return specializationRepository.findById(id);
    }

    public Iterable<Specialization> getSpecializations() {
    	Iterable<Specialization> result = specializationRepository.findAll();
    	LoggerTools.INSTANCE.logInfo(_className, "Call getSpecializations");
        return result;
    }

    public void deleteSpecialization(final Long id) {
    	specializationRepository.deleteById(id);
    	LoggerTools.INSTANCE.logInfo(_className, "Call deleteSpecialization id["+id+"]");

    }

    public Specialization saveSpecialization(Specialization specialization) {
    	Specialization savedSpecialization = specializationRepository.save(specialization);
    	LoggerTools.INSTANCE.logInfo(_className, "Call saveSpecialization id["+savedSpecialization.getId()+"]");
        return savedSpecialization;
    }

}
