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
import com.medhead.medhead.backend.model.Specialization;
import com.medhead.medhead.backend.service.HospitalService;
import com.medhead.medhead.backend.service.SpecializationGroupService;
import com.medhead.medhead.backend.service.SpecializationService;


@RestController
public class DatabaseController {


	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private SpecializationGroupService specializationGroupService;

	@Autowired
	private SpecializationService specializationService;


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
	public Hospital updateHospital(@PathVariable("id") final Long id, @RequestBody Hospital hospital) {
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
	public void deleteHospital(@PathVariable("id") final Long id) {
		hospitalService.deleteHospital(id);
	}

	/**
	 * Read - Get all specializations
	 * @return - An Iterable object of specialization full filled
	 */
	@GetMapping("/specializations")
	public Iterable<Specialization> getSpecializations() {
		return specializationService.getSpecializations();
	}

	/**
	 * Create - Add a new specialization
	 * @param specialization An object specialization
	 * @return The specialization object saved
	 */
	@PostMapping("/specialization")
	public Specialization createSpecialization(@RequestBody Specialization specialization) {
		return specializationService.saveSpecialization(specialization);
	}


	/**
	 * Read - Get one specialization 
	 * @param id The id of the specialization
	 * @return An Specialization object full filled
	 */
	@GetMapping("/specialization/{id}")
	public Specialization getSpecialization(@PathVariable("id") final Long id) {
		Optional<Specialization> specialization = specializationService.getSpecialization(id);
		if(specialization.isPresent()) {
			return specialization.get();
		} else {
			return null;
		}
	}

	/**
	 * Update - Update an existing specialization
	 * @param id - The id of the specialization to update
	 * @param specialization - The specialization object updated
	 * @return
	 */
	@PutMapping("/specialization/{id}")
	public Specialization updateSpecialization(@PathVariable("id") final Long id, @RequestBody Specialization specialization) {
		Optional<Specialization> e = specializationService.getSpecialization(id);
		if(e.isPresent()) {
			Specialization currentEmployee = e.get();

			//to do
			specializationService.saveSpecialization(specialization);
			return currentEmployee;
		} else {
			return null;
		}
	}


	/**
	 * Delete - Delete an specialization
	 * @param id - The id of the specialization to delete
	 */
	@DeleteMapping("/specialization/{id}")
	public void deleteSpecialization(@PathVariable("id") final Long id) {
		specializationService.deleteSpecialization(id);
	}

}
