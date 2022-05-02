package com.safetynetalert;


import com.safetynetalert.repository.FirestationRepository;
import com.safetynetalert.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import static com.safetynetalert.repository.FirestationRepository.getFirestationByStation;
import static com.safetynetalert.repository.PersonRepository.getByZip;
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

		System.out.println(getFirestationByStation(1));
		System.out.println(getFirestationByStation(2));
		System.out.println(getFirestationByStation(3));

		System.out.println("Hello World!");
		//system.out person list
		System.out.println(getByZip("55555"));

		}



	;
	}

