package com.wipro.usermgmtv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UsermgmtvApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermgmtvApplication.class, args);
	}

}