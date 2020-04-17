package com.patientapi.comtroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

	
	   @GetMapping("/greeting")
	    public String getMsg() {
	        return "i am  alive";
	    }
	   
	   
	   @GetMapping("/hello")
	    public String getHello() {
	        return "i am  alive : from patient";
	    }
	   
	   
	   @Value("${app.id}")
	    String instance;
	 
	    @GetMapping("/")
	    public String hi() {
	        return "Welcome, I am " + instance;
	    }
	
}
