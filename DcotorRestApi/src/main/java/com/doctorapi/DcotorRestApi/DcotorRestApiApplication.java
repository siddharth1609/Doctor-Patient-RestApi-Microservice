package com.doctorapi.DcotorRestApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DcotorRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcotorRestApiApplication.class, args);
	}

}

@RefreshScope
@RestController
class MessageRestController {
 
    @Value("${msg:Config Server is not working. Please check...}")
    private String msg;
 
    @GetMapping("/msg")
    public String getMsg() {
        return this.msg;
    }
}
