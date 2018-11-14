package com.appointments.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.net.spring.persistentlibrary.back.controller"})
public class AppointmentsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentsServerApplication.class, args);
	}
}
