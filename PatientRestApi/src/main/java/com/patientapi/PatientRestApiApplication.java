package com.patientapi;

import com.patientapi.model.Patient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.List;



@SpringBootApplication
@EnableEurekaClient
public class PatientRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientRestApiApplication.class, args);
		
		List<Patient> pList = new ArrayList<>();
		
		Patient p = new Patient();
		
		p.setPatientNo(1);
		p.setPatientname("A");
		pList.add(p);
		
	}

	
}

