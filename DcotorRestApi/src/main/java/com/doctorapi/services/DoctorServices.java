package com.doctorapi.services;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


public interface DoctorServices {

	public String readingList();
	
	
}
