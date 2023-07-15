package com.medhead.medhead.backend;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultRowSorter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import com.medhead.medhead.backend.model.Hospital;
import com.medhead.medhead.backend.service.HospitalService;
import com.medhead.medhead.backend.tool.GPSTools;


@SpringBootTest
class MedheadApplicationAPITests {

	
	@Value("${googleApiKey}")
	private String _apiGoogleKey;
	
    @Autowired
    private HospitalService hospitalService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void TestBddSelect() {
		Iterable<Hospital> ihospitals = hospitalService.getHospitals();
		for(Hospital h : ihospitals) {
			h.toString();
		}
	}
	
	@Test
	void TestGoogleAPI() throws Exception {
		
		
		GPSTools.INSTANCE.initGoogleApiKey(_apiGoogleKey);
		
		
		// Get All Hospital
		Iterable<Hospital> listHospital = hospitalService.getHospitals();
				
		// List for final Hospital with bed
		List<Hospital> listFinalHospital = new ArrayList<Hospital>();
		
		// fill the final list hospital
		for(Hospital hospital : listHospital) {
			listFinalHospital.add(hospital);
		}
		
		
		Hospital hospital = GPSTools.INSTANCE.bestHospitalGoogleApi(-21.114302, 55.654626, listFinalHospital);
		if(hospital== null)
			throw new Exception("result is null" );

	}


}
