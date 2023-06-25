package com.medhead.medhead.backend.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medhead.medhead.backend.model.Hospital;

import com.medhead.medhead.backend.repository.HospitalRepository;
import com.medhead.medhead.backend.tool.CommonTools;
import com.medhead.medhead.backend.tool.LoggerTools;

import lombok.Data;

@Data
@Service
public class HospitalService {
	
	/**
	 * Tag for the logs
	 */
	private final String _className = CommonTools.INSTANCE.getClassName(HospitalService.class);
	
    @Autowired
    private HospitalRepository hospitalRepository;

    public Optional<Hospital> getHospital(final Long id) {
    	LoggerTools.INSTANCE.logInfo(_className, "Call getHospital id["+id+"]");
        return hospitalRepository.findById(id);
    }

    public Iterable<Hospital> getHospitals() {
    	Iterable<Hospital> result = hospitalRepository.findAll();
    	LoggerTools.INSTANCE.logInfo(_className, "Call getHospitals");
        return result;
    }

    public void deleteHospital(final Long id) {
    	hospitalRepository.deleteById(id);
    	LoggerTools.INSTANCE.logInfo(_className, "Call deleteHospital id["+id+"]");

    }

    public Hospital saveHospital(Hospital hospital) {
    	Hospital savedHospital = hospitalRepository.save(hospital);
    	LoggerTools.INSTANCE.logInfo(_className, "Call saveHospital id["+savedHospital.getId()+"]");
        return savedHospital;
    }

}
