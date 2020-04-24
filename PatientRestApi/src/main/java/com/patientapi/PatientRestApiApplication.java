package com.patientapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patientapi.model.Patient;



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

