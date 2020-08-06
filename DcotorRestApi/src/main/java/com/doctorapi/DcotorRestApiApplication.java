package com.doctorapi;

import com.doctorapi.config.RibbonConfiguration;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;




@SpringBootApplication(scanBasePackages = {"com.doctorapi.controller","com.doctorapi.services","com.doctorapi"}) //important, otherwise crash
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



@RestController
class ELKController {
	private static final Logger LOG = LogManager.getLogger(DcotorRestApiApplication.class);
	
	
	
    @Autowired
    RestTemplate restTemplete;
 
    /*@Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }*/
 
    @RequestMapping(value = "/elkdemo")
    public String helloWorld() {
        String response = "Hello user ! " + new Date();
        LOG.log(Level.INFO, "/elkdemo - &gt; " + response);
 
        return response;
    }
 
    @RequestMapping(value = "/elk")
    public String helloWorld1() {
 
       
        
        
        //ResponseEntity<String> response = restTemplete.exchange("http://localhost:8080/elkdemo", HttpMethod.GET, null, String.class);
        String response = restTemplete.getForObject("http://localhost:8080/elkdemo", String.class);
        
        LOG.log(Level.INFO, "/elk - &gt; " + response);
 
        try {
            /*String exceptionrsp = restTemplete.exchange("http://localhost:8080/exception", HttpMethod.GET, null, new ParameterizedTypeReference() {
            }).getBody();
            */
           // ResponseEntity<String> exceptionrsp = restTemplete.exchange("http://localhost:8080/exception", HttpMethod.GET, null, String.class);
            
        	 String exceptionrsp = restTemplete.getForObject("http://localhost:8080/exception", String.class);
            
            LOG.log(Level.INFO, "/elk trying to print exception - &gt; " + exceptionrsp);
            response = response + " === " + exceptionrsp;
        } catch (Exception e) {
            // exception should not reach here. Really bad practice :)
        }
 
        return response;
    }
 
    @RequestMapping(value = "/exception")
    public String exception() {
        String rsp = "";
        try {
            int i = 1 / 0;
            // should get exception
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e);
             
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String sStackTrace = sw.toString(); // stack trace as a string
            LOG.error("Exception As String :: - &gt; "+sStackTrace);
             
            rsp = sStackTrace;
        }
 
        return rsp;
    }
}