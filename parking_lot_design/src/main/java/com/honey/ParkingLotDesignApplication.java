package com.honey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotDesignApplication {

	final static Logger logger = LoggerFactory.getLogger(ParkingLotDesignApplication.class);
	   
	public static void main(String[] args) {
		logger.info("\n\n\n##############\nStarting Spring Boot Application");
		SpringApplication.run(ParkingLotDesignApplication.class, args);
		logger.info("Successfully started the project");
	}

}
