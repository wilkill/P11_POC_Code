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
	 * getClosestHospitalByGpsPoint search by gps point distance
	 * @param hospital An object hospital
	 * @return The hospital object saved
	 */
	@PostMapping("/api/getclosesthospitalbygpspoint")
	public Hospital getClosestHospitalByGpsPoint(@RequestBody RequestParam requestParam) {
		long startTime = System.currentTimeMillis();
		LoggerTools.INSTANCE.logInfo(_className, "Call getClosestHospitalByGpsPoint id["+requestParam.toString()+"]");
		List<ResultSearch> lsrch = new ArrayList<ResultSearch>();
		Iterable<Hospital> listHospital = hospitalService.getHospitals();
		
		for(Hospital hospital : listHospital) {
			Double distance = GPSTools.INSTANCE.distanceTo(requestParam.getLatitude(), requestParam.getLongitude(), hospital.getLatitude(), hospital.getLongitude());
			lsrch.add(new ResultSearch(hospital, distance));
		}

		if(lsrch.size()>0) {
			Collections.sort(lsrch);
			LoggerTools.INSTANCE.logInfo(_className, "Call getClosestHospitalByGpsPoint result["+lsrch.get(0).getHospital().toString()+"]");
			long endTime = System.currentTimeMillis();
			long duration = (endTime - startTime);
			LoggerTools.INSTANCE.logInfo(_className, "Call getClosestHospitalByGpsPoint duration in seconds ["+duration/1000.0+"] à [" +lsrch.get(0).getDistance()/1000.0 + "] km");
			return lsrch.get(0).getHospital();
		}
		
		return null;
	}
	
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
		
		// Get All Hospital
		Iterable<Hospital> listHospital = hospitalService.getHospitals();
		
		// List for final Hospital with bed
		List<Hospital> listFinalHospital = new ArrayList<Hospital>();
		
		
		// fill the final list hospital
		for(Hospital hospital : listHospital) {
			if(hospital.containSpecialisationId(requestParam.getSpecialization()) && hospital.getBedsAvailable()>0)
				listFinalHospital.add(hospital);
		}
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
