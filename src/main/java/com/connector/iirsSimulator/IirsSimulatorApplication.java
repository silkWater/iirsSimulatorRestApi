package com.connector.iirsSimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IirsSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IirsSimulatorApplication.class, args);
		System.out.println("Started...");
	}
}