package com.medhead.medhead.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medhead.medhead.backend.model.Hospital;
import com.medhead.medhead.backend.service.HospitalService;


@RestController
public class DatabaseController {


    @Autowired
    private HospitalService hospitalService;
    
//    @Autowired
//    private SpecializationGroupService specializationGroupService;
//    
//    @Autowired
//    private SpecializationService specializationService;
    

    /**
    * Read - Get all hospitals
    * @return - An Iterable object of hospital full filled
    */
    @GetMapping("/hospitals")
    public Iterable<Hospital> getHospitals() {
        return hospitalService.getHospitals();
    }
    
    /**
	 * Create - Add a new hospital
	 * @param hospital An object hospital
	 * @return The hospital object saved
	 */
	@PostMapping("/hospital")
	public Hospital createHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}
	
	
	/**
	 * Read - Get one hospital 
	 * @param id The id of the hospital
	 * @return An Hospital object full filled
	 */
	@GetMapping("/hospital/{id}")
	public Hospital getHospital(@PathVariable("id") final Long id) {
		Optional<Hospital> hospital = hospitalService.getHospital(id);
		if(hospital.isPresent()) {
			return hospital.get();
		} else {
			return null;
		}
	}
	
	/**
	 * Update - Update an existing hospital
	 * @param id - The id of the hospital to update
	 * @param hospital - The hospital object updated
	 * @return
	 */
	@PutMapping("/hospital/{id}")
	public Hospital updateEmployee(@PathVariable("id") final Long id, @RequestBody Hospital hospital) {
		Optional<Hospital> e = hospitalService.getHospital(id);
		if(e.isPresent()) {
			Hospital currentEmployee = e.get();
			
			//to do
			hospitalService.saveHospital(hospital);
			return currentEmployee;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Delete - Delete an hospital
	 * @param id - The id of the hospital to delete
	 */
	@DeleteMapping("/hospital/{id}")
	public void deleteEmployee(@PathVariable("id") final Long id) {
		hospitalService.deleteHospital(id);
	}
	
}
