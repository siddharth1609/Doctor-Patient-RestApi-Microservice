package com.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaServerApplication.class, args);
	}
	





@RequestMapping("/home")
public String home(){
    return "Hello World!";
}
}



/*@RefreshScope
@RestController
class MessageRestController {
 
    @Value("${msg:Config Server is not working. Please check...}")
    private String msg;
 
    @GetMapping("/msg")
    public String getMsg() {
        return this.msg;
    }
}
*/

