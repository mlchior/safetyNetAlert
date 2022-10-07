package com.safetynetalert.service;

import com.safetynetalert.DTO.link2.AgeOfPersons;
import com.safetynetalert.DTO.link2.ChildAlert;
import com.safetynetalert.model.Medicalrecord;
import com.safetynetalert.model.Person;
import com.safetynetalert.repository.IFirestationRepository;
import com.safetynetalert.repository.IMedicalrecordRepository;
import com.safetynetalert.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
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


    public List<String> getCommunityEmail(String city) {
        Logger.info("getCommunityEmail SUCCESS" + city);
        return iPersonRepository.getCommunityEmail(city);
    }

    public Collection<Object> getPersonInfo(String firstName, String lastName) {
        Logger.info("getPersonInfo SUCCESS" + firstName + lastName);
        return iPersonRepository.getPersonInfo(firstName, lastName);
    }

    public List<Person> getPersonsByAddress(String address) {
        Logger.info("getPersonsByAddress SUCCESS" + address);
        return iPersonRepository.getPersonsByAddress(address);
    }

    private int calculateAge(String birthdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        int years = Period.between(LocalDate.parse(birthdate, formatter), LocalDate.now()).getYears();
        return years;
    }

    public List<ChildAlert> getChildAlert(String address) {
        List<Person> listPersonsByAddress = iPersonRepository.getPersonsByAddress(address);
        List<AgeOfPersons> ageOfPersonsList = new ArrayList<>();
        List<Medicalrecord> medicalRecords = iMedicalrecordRepository.getAll();
        List<AgeOfPersons> adulte = new ArrayList<>();
        List<AgeOfPersons> enfant = new ArrayList<>();
        List<ChildAlert> childAlertsList = new ArrayList<>();
        //1 recuper la liste de toute les personne qui habite a cette adresse listPersonsByAddress
        //2 pour la liste de toute les personne trouver leur birthdate dans medicalRecord and return listPersonsByAddressWithBirthDate
        //for listpersonsbyaddress if firstname and lastname == firstname and lastname in medicalrecord
        for (Person person : listPersonsByAddress) {
            for (Medicalrecord medicalrecord : medicalRecords) {
                if (person.getFirstName().equals(medicalrecord.getFirstName()) && person.getLastName().equals(medicalrecord.getLastName())) {
                    AgeOfPersons ageOfPersons = new AgeOfPersons();
                    ageOfPersons.setFirstName(person.getFirstName());
                    ageOfPersons.setLastName(person.getLastName());
                    ageOfPersons.setAge(calculateAge(medicalrecord.getBirthdate()));
                    ageOfPersonsList.add(ageOfPersons);
                }

            }

        }
        for (AgeOfPersons ageOfPersons : ageOfPersonsList) {
            if (ageOfPersons.getAge() < 18) {
                enfant.add(ageOfPersons);
            } else {
                adulte.add(ageOfPersons);
            }
        }

        for (AgeOfPersons ageOfPersons : enfant) {
            ChildAlert childAlert = new ChildAlert();
            childAlert.setFirstName(ageOfPersons.getFirstName());
            childAlert.setLastName(ageOfPersons.getLastName());
            childAlert.setAge(ageOfPersons.getAge());
            childAlert.setPersonWithChild(adulte);
            childAlertsList.add(childAlert);
        }

        return childAlertsList;
    }

    public List<Object> getFire(String address) {
        List<Person> listPersonsByAddress = iPersonRepository.getPersonsByAddress(address);
        List<Medicalrecord> medicalRecords = iMedicalrecordRepository.getAll();
        List<Object> listFire = new ArrayList<>();
        for (Person person : listPersonsByAddress) {
            for (Medicalrecord medicalrecord : medicalRecords) {
                if (person.getFirstName().equals(medicalrecord.getFirstName()) && person.getLastName().equals(medicalrecord.getLastName())) {
                    listFire.add(person);
                    listFire.add(medicalrecord);
                }
            }
        }
        return listFire;

    }


}

   /** public List<Object> getFlood(List<Integer> stations) {
        List<Object> listFlood = new ArrayList<>();
        List<Medicalrecord> medicalRecords = iMedicalrecordRepository.getAll();
        List<Person> listPersonsByAddress = new ArrayList<>();
        for (int station : stations) {
            listPersonsByAddress.addAll(iPersonRepository.getPersonsByAddress(iFirestationRepository.getFirestationByStation(station).getAddress()));
        }
        for (Person person : listPersonsByAddress) {
            for (Medicalrecord medicalrecord : medicalRecords) {
                if (person.getFirstName().equals(medicalrecord.getFirstName()) && person.getLastName().equals(medicalrecord.getLastName())) {
                    listFlood.add(person);
                    listFlood.add(medicalrecord);
                }
            }
        }
        return listFlood;
    }
}**/

        //3 calculer l'age de chaque personne
        //4 si l'age est inferieur a 18 on l'ajoute a la liste des enfants
        //5 on ajoute a la liste des enfants la liste des personne qui habite a cette adresse
        //6 on retourne la liste des enfants

        /*for (Person person : persons) {
            if (person.getAddress().equals(address)) {
                AgeOfPersons ageOfPersons = new AgeOfPersons();
                ageOfPersons.setFirstName(person.getFirstName());
                ageOfPersons.setLastName(person.getLastName());
                // calculate age of ageOfPersons with medicalRecords
            }
            for (AgeOfPersons ageOfPersons : ageOfPersonsList) {
                for (Medicalrecord medicalrecord : medicalRecords) {
                    if (medicalrecord.getFirstName().equals(ageOfPersons.getFirstName()) && medicalrecord.getLastName().equals(ageOfPersons.getLastName())) {
                        ageOfPersons.setBirthDate(medicalrecord.getBirthdate());
                    }
                }
            }
            for (AgeOfPersons ageOfPersons : ageOfPersonsList) {
                Date date = null;
                Date date2 = null;
                date2 = new Date();

                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                try {
                    date = dateFormat.parse(ageOfPersons.getBirthDate());
                    date2 = dateFormat.parse(dateFormat.format(date2));


                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                int age = date2.getYear() - date.getYear();
                ageOfPersons.setAge(age);
                System.out.println(ageOfPersons.getAge());
            }


        }



        return childAlertList;
    }**/





