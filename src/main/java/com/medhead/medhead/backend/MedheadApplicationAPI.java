package com.medhead.medhead.backend;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.medhead.medhead.backend.tool.GPSTools;
import com.medhead.medhead.backend.tool.LoggerTools;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MedheadApplicationAPI {

	@Value("${googleApiKey}")
	private String _apiGoogleKey;
	
	@PostConstruct
	public void init() {
		
		LoggerTools.INSTANCE.init("MedheadApplicationAPI");
		GPSTools.INSTANCE.initGoogleApiKey(_apiGoogleKey);
	}

	public static void main(String[] args) {
		SpringApplication.run(MedheadApplicationAPI.class, args);
	}
	


}
