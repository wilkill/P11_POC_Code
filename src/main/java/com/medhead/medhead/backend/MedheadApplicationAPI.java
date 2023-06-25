package com.medhead.medhead.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.medhead.medhead.backend.tool.LoggerTools;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MedheadApplicationAPI {

	@PostConstruct
	public void init() {
		LoggerTools.INSTANCE.init("MedheadApplicationAPI");

	}

	public static void main(String[] args) {
		SpringApplication.run(MedheadApplicationAPI.class, args);
	}

}
