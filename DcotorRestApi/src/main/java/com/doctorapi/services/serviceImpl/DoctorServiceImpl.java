package com.doctorapi.services.serviceImpl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.doctorapi.services.DoctorServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@Configuration 
public class DoctorServiceImpl  implements DoctorServices{
	
     @Autowired	  
	 RestTemplate restTemplate;
		
	

	@HystrixCommand(fallbackMethod = "reliable")
	  public String readingList() {
	  URI uri = URI.create("http://localhost:9300/getPatientList1");

	  return this.restTemplate.getForObject(uri, String.class);
	  }

	  public String reliable() {
	  return "Cloud Native Java (O'Reilly)";
	  }
	
	
	    @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }

}
