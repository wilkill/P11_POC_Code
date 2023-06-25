package com.medhead.medhead.backend.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medhead.medhead.backend.model.SpecializationGroup;

import com.medhead.medhead.backend.repository.SpecializationGroupRepository;
import com.medhead.medhead.backend.tool.CommonTools;
import com.medhead.medhead.backend.tool.LoggerTools;

import lombok.Data;

@Data
@Service
public class SpecializationGroupService {
	
	/**
	 * Tag for the logs
	 */
	private final String _className = CommonTools.INSTANCE.getClassName(SpecializationGroupService.class);
	
    @Autowired
    private SpecializationGroupRepository specializationGroupRepository;

    public Optional<SpecializationGroup> getSpecializationGroup(final Long id) {
    	LoggerTools.INSTANCE.logInfo(_className, "Call getSpecializationGroup id["+id+"]");
        return specializationGroupRepository.findById(id);
    }

    public Iterable<SpecializationGroup> getSpecializationGroups() {
    	Iterable<SpecializationGroup> result = specializationGroupRepository.findAll();
    	LoggerTools.INSTANCE.logInfo(_className, "Call getSpecializationGroups");
        return result;
    }

    public void deleteSpecializationGroup(final Long id) {
    	specializationGroupRepository.deleteById(id);
    	LoggerTools.INSTANCE.logInfo(_className, "Call deleteSpecializationGroup id["+id+"]");

    }

    public SpecializationGroup saveSpecializationGroup(SpecializationGroup specializationGroup) {
    	SpecializationGroup savedSpecializationGroup = specializationGroupRepository.save(specializationGroup);
    	LoggerTools.INSTANCE.logInfo(_className, "Call saveSpecializationGroup id["+savedSpecializationGroup.getId()+"]");
        return savedSpecializationGroup;
    }

}
