package com.medhead.medhead.backend.model;

public class RequestParam {
	
	private int specialization;
	private double latitude;
	private double longitude;
	public int getSpecialization() {
		return specialization;
	}
	public void setSpecialization(int specialization) {
		this.specialization = specialization;
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
	public RequestParam(int specialization, double longitude, double latitude) {
		super();
		this.specialization = specialization;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public RequestParam() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RequestParam [specialization=");
		builder.append(specialization);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append("]");
		return builder.toString();
	}
	
	

}
