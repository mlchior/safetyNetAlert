package com.safetynetalert;


import com.safetynetalert.repository.FirestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.safetynetalert.repository.FirestationRepository.getFirestationByStation;

/**luncher of the application*/

@SpringBootApplication
public class SafetyNetAlertApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(SafetyNetAlertApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		FirestationRepository.initFirestation();
		System.out.println(getFirestationByStation(1));
		System.out.println(getFirestationByStation(2));
		System.out.println(getFirestationByStation(3));
		System.out.println("Hello World!");

		};
	}

