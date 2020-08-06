package com.patientapi.controller;

import com.patientapi.model.Patient;
import com.patientapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
	
	   @Autowired
	   private PatientService  patientService;

	
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
	    
	    
	    
	  @GetMapping("/getPatientList")  
	   public List<Patient> getPatient(){
		   
		   List<Patient> pList = patientService.getPatientList();
		   
		   
		   return pList;
	   } 
	    
	    
	    
	    
	    
	    
	
}
