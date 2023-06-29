package com.medhead.medhead.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.medhead.medhead.backend.model.Hospital;
import com.medhead.medhead.backend.service.HospitalService;


@SpringBootTest
class MedheadApplicationAPITests {

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

}
