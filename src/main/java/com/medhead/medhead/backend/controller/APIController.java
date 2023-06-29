package com.medhead.medhead.backend.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medhead.medhead.backend.model.Hospital;
import com.medhead.medhead.backend.model.RequestParam;
import com.medhead.medhead.backend.model.ResultSearch;
import com.medhead.medhead.backend.service.HospitalService;
import com.medhead.medhead.backend.service.SpecializationGroupService;
import com.medhead.medhead.backend.service.SpecializationService;
import com.medhead.medhead.backend.tool.CommonTools;
import com.medhead.medhead.backend.tool.GPSTools;
import com.medhead.medhead.backend.tool.LoggerTools;

@RestController
public class APIController {
	
	/**
	 * Tag for the logs
	 */
	private final String _className = CommonTools.INSTANCE.getClassName(APIController.class);
	
    @Autowired
    private HospitalService hospitalService;
    
    @Autowired
    private SpecializationGroupService specializationGroupService;
    
    @Autowired
    private SpecializationService specializationService;
    
    
    /**
	 * Create - Add a new hospital
	 * @param hospital An object hospital
	 * @return The hospital object saved
	 */
	@PostMapping("/api/getclosesthospital")
	public Hospital getClosestHospital(@RequestBody RequestParam requestParam) {
		LoggerTools.INSTANCE.logInfo(_className, "Call getClosestHospital id["+requestParam.toString()+"]");
		List<ResultSearch> lsrch = new ArrayList<ResultSearch>();
		Iterable<Hospital> listHospital = hospitalService.getHospitals();
		
		for(Hospital hospital : listHospital) {
			Double distance = GPSTools.INSTANCE.distanceTo(requestParam.getLatitude(), requestParam.getLongitude(), hospital.getLatitude(), hospital.getLongitude());
			lsrch.add(new ResultSearch(hospital, distance));
		}
		if(lsrch.size()>0) {
			Collections.sort(lsrch);
			LoggerTools.INSTANCE.logInfo(_className, "Call getClosestHospital resust["+lsrch.get(0).getHospital().toString()+"]");
			return lsrch.get(0).getHospital();
		}
		
		return null;
	}

}
