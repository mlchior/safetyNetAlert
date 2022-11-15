package com.safetynetalert.service;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.IFirestationRepository;
import com.safetynetalert.repository.IMedicalrecordRepository;
import com.safetynetalert.repository.IPersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;
import java.util.ArrayList;
import java.util.List;



@Service
public class PersonService {
    @Autowired
    private IPersonRepository iPersonRepository;
    @Autowired
    private IMedicalrecordRepository iMedicalrecordRepository;

    @Autowired
    IFirestationRepository iFirestationRepository;

    public PersonService(IPersonRepository ipersonRepository) {

    }

    public List<Person> findAllPerson() {
        Logger.info("findAllPerson SUCCESS");
        return iPersonRepository.getAll();
    }

    public Person addPerson(Person person) {
        Logger.info("addPerson SUCCESS" + person);
        return iPersonRepository.addPerson(person);
    }

    public Person updatePerson(Person person) {
        Logger.info("updatePerson SUCCESS" + person);
        return iPersonRepository.updatePerson(person);
    }

    public Person deletePerson(String firstName, String lastName) {
        Logger.info("deletePerson SUCCESS" + firstName + lastName);
        return iPersonRepository.deletePerson(firstName, lastName);
    }

    public List<Person> getPersonsByAddress(String address) {
        Logger.info("getPersonsByAddress SUCCESS" + address);
        return iPersonRepository.getPersonsByAddress(address);
    }
}





