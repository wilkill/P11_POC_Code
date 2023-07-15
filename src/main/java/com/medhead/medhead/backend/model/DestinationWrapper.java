package com.medhead.medhead.backend.model;

import com.google.maps.model.LatLng;

public class DestinationWrapper {
	
	private Hospital hostipal;
	private LatLng latLng;
	
	
	
	
	
	
	
	public DestinationWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DestinationWrapper(Hospital hostipal, LatLng latLng) {
		super();
		this.hostipal = hostipal;
		this.latLng = latLng;
	}



	public Hospital getHostipal() {
		return hostipal;
	}
	
	public void setHostipal(Hospital hostipal) {
		this.hostipal = hostipal;
	}

	public LatLng getLatLng() {
		return latLng;
	}

	public void setLatLng(LatLng latLng) {
		this.latLng = latLng;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DestinationWrapper [");
		if (hostipal != null) {
			builder.append("hostipal=");
			builder.append(hostipal);
			builder.append(", ");
		}
		if (latLng != null) {
			builder.append("latLng=");
			builder.append(latLng);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
