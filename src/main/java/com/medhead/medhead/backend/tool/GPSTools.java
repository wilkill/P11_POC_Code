package com.medhead.medhead.backend.tool;

public enum GPSTools {
	
	/**
	 * Tag for the singleton
	 */
	INSTANCE;
	
	
	/**
	 * 
	 * Method : to get distance between two GPS point
	 * 
	 * @param latitudeOrigine
	 * @param longitudeOrigine
	 * @param latitudeOrlatitudeDestigine
	 * @param longitudeDest
	 * @return Double
	 */
	public double distanceTo(double latitudeOrigine,double longitudeOrigine ,double latitudeDest,double longitudeDest ) {
	    double earthRadius = 6371; // Rayon de la Terre en kilomètres
	    double dLat = Math.toRadians(latitudeDest - latitudeOrigine);
	    double dLon = Math.toRadians(longitudeDest - longitudeOrigine);
	    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
	               Math.cos(Math.toRadians(latitudeOrigine)) * Math.cos(Math.toRadians(latitudeDest)) *
	               Math.sin(dLon / 2) * Math.sin(dLon / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = earthRadius * c * 1000; // Conversion en mètres
	    return distance;
	}

}
