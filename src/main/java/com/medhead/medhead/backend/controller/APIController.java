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
    
	
	/**
	 * get closest hospital by api google street
	 * @param hospital An object hospital
	 * @return The hospital object saved
	 */
	@PostMapping("/api/getclosesthospitalbygoogleapi")
	public Hospital getClosestHospitalGoogleAPI(@RequestBody RequestParam requestParam) {
		// Create the result return
		Hospital resultHospital = null;
		
		// Start Date of this method
		long startTime = System.currentTimeMillis();
		LoggerTools.INSTANCE.logInfo(_className, "Call getClosestHospitalGoogleAPI id["+requestParam.toString()+"]");
		
		// List for final Hospital with bed
		List<Hospital> listFinalHospital = hospitalService.getHospitalsBySpecialisationAndBedAvailable(requestParam.getSpecialization());
		
		if(!listFinalHospital.isEmpty())
			resultHospital = GPSTools.INSTANCE.bestHospitalGoogleApi(requestParam.getLatitude(), requestParam.getLongitude(), listFinalHospital);

		
		// Start End of this method
		long endTime = System.currentTimeMillis();
		
		// Duration of this method
		long duration = (endTime - startTime);
		LoggerTools.INSTANCE.logInfo(_className, "Call getClosestHospitalGoogleAPI duration in seconds ["+duration/1000.0+"]");
		
		
		return resultHospital;
	}

}
