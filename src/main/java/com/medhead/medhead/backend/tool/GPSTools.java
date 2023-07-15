package com.medhead.medhead.backend.tool;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import com.medhead.medhead.backend.model.DestinationWrapper;
import com.medhead.medhead.backend.model.Hospital;
import com.medhead.medhead.backend.service.SpecializationService;

public enum GPSTools {
	

	/**
	 * Tag for the singleton
	 */
	INSTANCE;
	
	/**
	 * Tag for the logs
	 */
	private final String _className = CommonTools.INSTANCE.getClassName(GPSTools.class);
	
	/**
	 * Tag for the google api token
	 */

	private String _apiGoogleKey;
	GeoApiContext _context ;
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
	
	public void initGoogleApiKey(String apikey) {
		this._apiGoogleKey = apikey;
		if(this._apiGoogleKey!=null)
			// Init context api google
	        _context = new GeoApiContext.Builder()
	                .apiKey(_apiGoogleKey)
	                .build();

		LoggerTools.INSTANCE.logInfo(_className,"Init done with key not null [" + (apikey==null ? false:true) +"]");
	}
	
	/*
	 *  Google Api search closest hospital
	 * 
	 * @param apiKey
	 * @return boolean
	 */
	public Hospital bestHospitalGoogleApi(double latitude,double longitude,List<Hospital> hospitals) {
		
		

        
        // point GPS for the start point 
        LatLng startPoint = new LatLng(latitude, longitude); 
        
        //fill destinations from hospital list
        DestinationWrapper[] destinations = new DestinationWrapper[hospitals.size()];
        int count = 0;
        for(Hospital h : hospitals) {
        	destinations[count] = new DestinationWrapper(h,new LatLng(h.getLatitude(), h.getLongitude()));
        	count++;
        }

        
        try {
            // Google api query matrix
            DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(_context)
                    .origins(startPoint)
                    .destinations(getLatLngArray(destinations))
                    .mode(TravelMode.DRIVING); // Transport mode with vehicle

            DistanceMatrix result = request.await();

            // Analyze result
            if (result.rows.length > 0) {
                DistanceMatrixRow closestRow = result.rows[0];
                
                int currentIdx = -1;
                long currentDistance = -1;
                for(int idx = 0 ; idx< closestRow.elements.length ; idx++) {
                	if(currentDistance == -1) {
                		currentDistance = closestRow.elements[idx].distance.inMeters;
                		currentIdx = idx;
                	}
                	if(currentDistance > closestRow.elements[idx].distance.inMeters) {
                		currentDistance = closestRow.elements[idx].distance.inMeters;
                		currentIdx = idx;
                	}
                }
                
                DestinationWrapper closestDestination = destinations[currentIdx];
               
                
                LoggerTools.INSTANCE.logInfo(_className, "L'hopital le plus proche est le  : [ " + closestDestination.getHostipal().toString() + "] à [" + currentDistance/1000.0 + "] km");
                return closestDestination.getHostipal();
            }
        } catch (Exception e) {
        	LoggerTools.INSTANCE.logError(_className, e.getMessage());
        }
        
        
        return null;
	}
	
    private static LatLng[] getLatLngArray(DestinationWrapper[] destinations) {
        LatLng[] latLngArray = new LatLng[destinations.length];
        for (int i = 0; i < destinations.length; i++) {
            latLngArray[i] = destinations[i].getLatLng();
        }
        return latLngArray;
    }

}
