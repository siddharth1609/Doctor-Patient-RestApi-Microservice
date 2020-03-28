package com.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaCloudApplication.class, args);
	}

}
