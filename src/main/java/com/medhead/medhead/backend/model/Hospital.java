package com.medhead.medhead.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hospital")
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	
	private Integer[] specializations; 
	
	private double latitude;
	
	private double longitude;
	
	@Column(name = "beds_available")
	private int bedsAvailable;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer[] getSpecializations() {
		return specializations;
	}

	public void setSpecializations(Integer[] specializations) {
		this.specializations = specializations;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public Integer getBedsAvailable() {
		return bedsAvailable;
	}

	public void setBedsAvailable(Integer bedsAvailable) {
		this.bedsAvailable = bedsAvailable;
	}

	public boolean containSpecialisationId(Integer searchId) {
		
		if(this.getSpecializations() != null) {
			for(Integer i : this.getSpecializations()) {
				if(i == searchId)
					return true;
			}
			
		}
		
		return false;
	}
	
}
