package com.safetynetalert;


import com.safetynetalert.model.Database;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tinylog.Logger;

/**luncher of the application*/

@SpringBootApplication
public class SafetyNetAlertApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SafetyNetAlertApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	Logger.info("Application started");
	Logger.trace("Application started");
	Logger.debug("Application started");



		Database db = new Database();
		db.init();


	}
}

