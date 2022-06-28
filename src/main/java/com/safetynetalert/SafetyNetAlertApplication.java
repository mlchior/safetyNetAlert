package com.safetynetalert;


import com.safetynetalert.model.Database;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.MedicalRecordRepository;
import com.safetynetalert.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import static com.safetynetalert.repository.PersonRepository.getByZip ;


/**luncher of the application*/

@SpringBootApplication
public class SafetyNetAlertApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger("SafetyNetAlertApplication");
	public static void main(String[] args) {
		SpringApplication.run(SafetyNetAlertApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		logger.info("initializing SafetyNetAlertApplication toudoum");
		Database db = new Database();

		db.init();
	}
}

