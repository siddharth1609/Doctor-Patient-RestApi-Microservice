package com.patientapi.comtroller;

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
	
}
