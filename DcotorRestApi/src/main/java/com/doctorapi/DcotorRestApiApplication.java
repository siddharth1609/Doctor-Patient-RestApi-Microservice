package com.doctorapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapi.config.RibbonConfiguration;



@SpringBootApplication(scanBasePackages = {"com.doctorapi.controller","com.doctorapi.services"}) //important, otherwise crash
@EnableDiscoveryClient
@EnableFeignClients
@RibbonClient(name = "ribbon-app", configuration = RibbonConfiguration.class)
@EnableHystrixDashboard
@EnableCircuitBreaker
public class DcotorRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcotorRestApiApplication.class, args);
	}

	
}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${message:Hello default}")
	private String message;

	@RequestMapping("/message")
	String getMessage() {
		return this.message;
	}
}

//http://melardev.com/blog/2019/02/20/spring-cloud-feign/