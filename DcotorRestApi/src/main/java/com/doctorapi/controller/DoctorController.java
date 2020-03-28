package com.doctorapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapi.patientclient.RestClient;

@RestController
public class DoctorController {

	final RestClient restClient;

	@Autowired
	public DoctorController(RestClient restClient) {
		this.restClient = restClient;

	}
	
	
	
	@GetMapping("/hellopatient")
	public String helloPatient() {
		 
		return restClient.getHello();
    }

	/*
	 * @GetMapping("/greeting") public String getMsg() { return "i am  alive"; }
	 */

}
