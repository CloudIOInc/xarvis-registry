package com.xoriant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class XarvisRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(XarvisRegistryApplication.class, args);
	}

}
