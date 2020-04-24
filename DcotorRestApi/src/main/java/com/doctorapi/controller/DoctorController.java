package com.doctorapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.doctorapi.patientclient.RestClient;
import com.doctorapi.services.DoctorServices;


@RestController
public class DoctorController {
	
	@Autowired(required=true)
	private DoctorServices doctorServices;
	
    
	@Autowired
    DiscoveryClient discoveryClient;
 
    @Autowired
    LoadBalancerClient loadBalancerClient;
	
	
	
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

	@RequestMapping("/load-balance")
	public String serverLocation(Model model) {
		
		String serviceId = "patient-service";
		
		List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
		if (instances != null && !instances.isEmpty()) {
            RestTemplate restTemplate = new RestTemplate();
 
            model.addAttribute("serviceId", serviceId);
            model.addAttribute("instances", instances);
 
            
            try {
 
                ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
 
                String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort();
                String result = restTemplate.getForObject(url, String.class);
 
                model.addAttribute("url", url);
                model.addAttribute("result", result);
 
            } catch (IllegalStateException e) {
                model.addAttribute("Error", e.getMessage());
                e.printStackTrace();
            }
            
            System.out.println("SID:"+model.toString());
        }
        return "index";
	}
	
	  @GetMapping("/to-read")
	  public String toRead() {
	  return doctorServices.readingList();
	  }
	
	
}
