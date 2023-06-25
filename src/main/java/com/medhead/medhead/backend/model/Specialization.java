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
@Table(name = "specialization")
public class Specialization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "specialization_group_id")
	private Long specializationGroupId;
	
	private String name;

	
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

	public Long getSpecializationGroupId() {
		return specializationGroupId;
	}

	public void setSpecializationGroupId(Long specializationGroupId) {
		this.specializationGroupId = specializationGroupId;
	}
	
	
	
}
