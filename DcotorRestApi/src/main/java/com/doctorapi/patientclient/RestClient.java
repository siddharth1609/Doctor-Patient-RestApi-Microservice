package com.doctorapi.patientclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("patient-service")
public interface RestClient {
	
   @RequestMapping("/hello")	
   String getHello();
	   

	
	
}
