package com.axis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class ProjectAppointment1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectAppointment1Application.class, args);
	}

}
