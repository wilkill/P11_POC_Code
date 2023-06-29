package com.medhead.medhead.backend.model;

public class ResultSearch implements Comparable<ResultSearch>{

	private Hospital hospital;
	private Double distance;



	public ResultSearch(Hospital hospital, Double distance) {
		super();
		this.hospital = hospital;
		this.distance = distance;
	}


	public ResultSearch() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(ResultSearch o) {
		return new Double(distance).compareTo(o.distance);
	}

}
