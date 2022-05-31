package com.safetynetalert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.safetynetalert.model.Database;
import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.MedicalRecordRepository;
import com.safetynetalert.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;


import static com.safetynetalert.repository.PersonRepository.getByZip ;


/**luncher of the application*/

@SpringBootApplication
public class SafetyNetAlertApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(SafetyNetAlertApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		FirestationRepository.initFirestation();
		PersonRepository.initPersonList();
		MedicalRecordRepository.initMedicalRecordList();
		Database db = new Database();
		FirestationRepository.initFirestation();
		PersonRepository.initPersonList();
		MedicalRecordRepository.initMedicalRecordList();
		db.init();
	}
}

